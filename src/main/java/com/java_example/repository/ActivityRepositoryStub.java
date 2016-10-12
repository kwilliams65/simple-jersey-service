package com.java_example.repository;

import com.java_example.model.Activity;
import com.java_example.model.User;

import java.util.ArrayList;
import java.util.List;

public class ActivityRepositoryStub implements ActivityRepository {

    @Override
    public List<Activity> findAllActivities() {
        List<Activity> activities = new ArrayList<Activity>();

        Activity activity1 = new Activity();
        activity1.setDescription("Swimming");
        activity1.setDuration(55);
        activities.add(activity1);

        Activity activity2 = new Activity();
        activity2.setDescription("Cycling");
        activity2.setDuration(120);
        activities.add(activity2);

        return activities;
    }

    @Override
    public Activity findActivity(String activityId) {

        if (activityId.equals("7777"))
            return null;

        Activity activity1 = new Activity();
        activity1.setId("1234");
        activity1.setDescription("Swimming");
        activity1.setDuration(55);

        User user = new User();
        user.setId("5678");
        user.setName("Kate");

        activity1.setUser(user);

        return activity1;
    }

    @Override
    public void Create(Activity activity) {
        //should issue an insert statement to the db
    }

    @Override
    public Activity update(Activity activity) {
        //search database to see if we have an activity with that id already
        //select * from Activity where id = ?
        //if rs size == 0, insert into table, else update table

        return activity;
    }

    @Override
    public void delete(String activityId) {
        //delete from Activity table where activityId ==
    }

    @Override
    public List<Activity> findByDescription(List<String> descriptions) {
        //select * from Activities where description is in (?,?,?...)
        List<Activity> activities = new ArrayList<Activity>();

        Activity activity = new Activity();
        activity.setId("2345");
        activity.setDescription("swimming");
        activity.setDuration(55);
        activities.add(activity);

        return activities;
    }
}
