package com.example.bidblitz.model;

/**
 * @author Team 6
 */

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "activity_logs")
public class ActivityLog implements Serializable {

    public static final String ACTION_CREATE  = "CREATE";
    public static final String ACTION_UPDATE  = "UPDATE";
    public static final String ACTION_DELETE  = "DELETE";
    public static final String ACTION_BID     = "BID";
    public static final String ACTION_LOGIN   = "LOGIN";
    public static final String ACTION_LOGOUT  = "LOGOUT";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "actor_id")
    private User actor;

    @Column(name = "action_type", nullable = false)
    private String actionType;

    @Column(name = "target_entity")
    private String targetEntity;

    @Column(name = "target_id")
    private int targetId;

    @Column(name = "description")
    private String description;

    public ActivityLog() {
        this.timestamp = LocalDateTime.now();
    }

    public ActivityLog(User actor, String actionType, String targetEntity, int targetId, String description) {
        this.timestamp = LocalDateTime.now();
        this.actor = actor;
        this.actionType = actionType;
        this.targetEntity = targetEntity;
        this.targetId = targetId;
        this.description = description;
    }

    public int getId() { return id; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public User getActor() { return actor; }
    public String getActionType() { return actionType; }
    public String getTargetEntity() { return targetEntity; }
    public int getTargetId() { return targetId; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return "ActivityLog{"
                + "id=" + id
                + ", timestamp=" + timestamp
                + ", actor='" + (actor != null ? actor.getUsername() : "N/A") + "'"
                + ", action='" + actionType + "'"
                + ", target='" + targetEntity + "[" + targetId + "]'"
                + "}";
    }
}
