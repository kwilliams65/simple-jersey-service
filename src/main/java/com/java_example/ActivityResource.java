package com.java_example;

import com.java_example.model.Activity;
import com.java_example.model.User;
import com.java_example.repository.ActivityRepository;
import com.java_example.repository.ActivityRepositoryStub;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.rmi.activation.ActivationID;
import java.util.List;

@Path("activities")
public class ActivityResource {

    private ActivityRepository activityRepository = new ActivityRepositoryStub();

    @POST
    @Path("activity")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Activity createActivity(Activity activity) {
        System.out.println(activity.getDescription());
        System.out.println(activity.getDuration());
        activityRepository.Create(activity);
        return activity;
    }

    @POST
    @Path("activity")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Activity createActivityParams(MultivaluedMap<String, String> formParams) {
        System.out.println(formParams.getFirst("description"));
        System.out.println(formParams.getFirst("duration"));

        Activity activity = new Activity();
        activity.setDescription(formParams.getFirst("description"));
        activity.setDuration(Integer.parseInt(formParams.getFirst("duration")));

        activityRepository.Create(activity);

        return activity;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Activity> GetAllActivities() {
        return activityRepository.findAllActivities();
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("{activityId}")
//    public Activity GetActivity(@PathParam("activityId") String activityId) {
//        return activityRepository.findActivity(activityId);
//    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{activityId}")
    public Response GetActivity(@PathParam("activityId") String activityId) {
        if (activityId == null || activityId.length() < 4)
            return Response.status(Response.Status.BAD_REQUEST).build();

        Activity activity = activityRepository.findActivity(activityId);

        if (activity == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok().entity(activity).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{activityId}/user")
    public User GetActivityUser(@PathParam("activityId") String activityId) {
        return activityRepository.findActivity(activityId).getUser();
    }

    @PUT
    @Path("{activityId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response Update(Activity activity) {

        System.out.println(activity.getId());

        activity = activityRepository.update(activity);

        return Response.ok().entity(activity).build();
    }

    @DELETE
    @Path("{activityId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response Delete(@PathParam("activityId") String activityId) {
        System.out.println(activityId);

        activityRepository.delete(activityId);

        return Response.ok().build();
    }
}
