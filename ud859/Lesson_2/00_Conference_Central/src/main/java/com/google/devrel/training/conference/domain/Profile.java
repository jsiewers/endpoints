package com.google.devrel.training.conference.domain;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.devrel.training.conference.form.ProfileForm.TeeShirtSize;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;


// TODO indicate that this class is an Entity
@Entity
public class Profile {
	String displayName;
	String mainEmail;
	TeeShirtSize teeShirtSize;
	
	private List <String> conferenceKeys = new ArrayList<>(0);

	// TODO indicate that the userId is to be used in the Entity's key
	@Id
	String userId;
    
    /**
     * Public constructor for Profile.
     * @param userId The user id, obtained from the email
     * @param displayName Any string user wants us to display him/her on this system.
     * @param mainEmail User's main e-mail address.
     * @param teeShirtSize The User's tee shirt size
     * 
     */
    public Profile (String userId, String displayName, String mainEmail, TeeShirtSize teeShirtSize) {
    	this.userId = userId;
    	this.displayName = displayName;
    	this.mainEmail = mainEmail;
    	this.teeShirtSize = teeShirtSize;
    }
    
    public void update(String displayName, TeeShirtSize teeShirtSize) {
    	if (displayName != null) {
    		this.displayName = displayName;
    	}
    	if (teeShirtSize != null) {
    		this.teeShirtSize = teeShirtSize;
    	}
 	
    }
    
    
    public List<String> getConferenceKeysToAttend() {
    	return ImmutableList.copyOf(conferenceKeys);
    }
    
    public void addToConferenceKeysToAttend(String key) {
    	conferenceKeys.add(key);
    }
    
    public void unregisterFromConference(String key) {
    	if(conferenceKeys.contains(key)) {
    		conferenceKeys.remove(key);
    	} else {
    		throw new IllegalArgumentException("Invalid conferenceKey: " + key);
    	}
     }
    
    
	public String getDisplayName() {
		return displayName;
	}

	public String getMainEmail() {
		return mainEmail;
	}

	public TeeShirtSize getTeeShirtSize() {
		return teeShirtSize;
	}

	public String getUserId() {
		return userId;
	}

	/**
     * Just making the default constructor private.
     */
    private Profile() {}

}
