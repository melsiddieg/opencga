package org.opencb.opencga.catalog.models;

import java.util.List;

/**
 * Created on 21/08/15
 *
 * @author Jacobo Coll &lt;jacobo167@gmail.com&gt;
 */
public class Group {

    /**
     * Group name, unique in the belonging study
     */
    private String id;

    /**
     * Set of users belonging to this group
     */
    private List<String> userIds;

    /**
     * Group permissions over one study
     */
    private StudyPermissions permissions;

    public Group() {
    }

    public Group(String id, List<String> userIds, StudyPermissions permissions) {
        this.id = id;
        this.userIds = userIds;
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + id + '\'' +
                ", userIds='" + userIds + '\'' +
                ", permissions=" + permissions +
                '}';
    }

    public String getId() {
        return id;
    }

    public Group setId(String id) {
        this.id = id;
        return this;
    }

    public List<String> getUserIds() {
        return userIds;
    }

    public Group setUserIds(List<String> userIds) {
        this.userIds = userIds;
        return this;
    }

    public StudyPermissions getPermissions() {
        return permissions;
    }

    public Group setPermissions(StudyPermissions permissions) {
        this.permissions = permissions;
        return this;
    }
}

