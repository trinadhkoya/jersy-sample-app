package io.trinadhkoya.github.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.trinadhkoya.github.database.DataBaseClass;
import io.trinadhkoya.github.model.Profile;

public class ProfileServie {

	Map<Long, Profile> profiles = DataBaseClass.getProfiles();

	public ProfileServie() {
		// TODO Auto-generated constructor stub
		profiles.put(1L, new Profile(1, "trinadhkoya", "trinadh", "koya"));
		profiles.put(2L, new Profile(2, "stevenpaul", "Steven", "Paul"));
		profiles.put(3L, new Profile(2, "stevenpaul", "Steven", "Paul"));
		profiles.put(4L, new Profile(2, "stevenpaul", "Steven", "Paul"));
		profiles.put(5L, new Profile(2, "stevenpaul", "Steven", "Paul"));
		profiles.put(6L, new Profile(2, "stevenpaul", "Steven", "Paul"));
		profiles.put(7L, new Profile(2, "stevenpaul", "Steven", "Paul"));
		profiles.put(8L, new Profile(2, "stevenpaul", "Steven", "Paul"));
		profiles.put(9L, new Profile(2, "stevenpaul", "Steven", "Paul"));
		profiles.put(10L, new Profile(2, "stevenpaul", "Steven", "Paul"));
		profiles.put(11L, new Profile(2, "stevenpaul", "Steven", "Paul"));
		profiles.put(12L, new Profile(2, "stevenpaul", "Steven", "Paul"));
		profiles.put(13L, new Profile(2, "stevenpaul", "Steven", "Paul"));
		profiles.put(14L, new Profile(2, "stevenpaul", "Steven", "Paul"));
		profiles.put(15L, new Profile(2, "stevenpaul", "Steven", "Paul"));
		profiles.put(16L, new Profile(2, "stevenpaul", "Steven", "Paul"));
		profiles.put(17L, new Profile(2, "stevenpaul", "Steven", "Paul"));


	}

	public List<Profile> getAllProfiles() {

		return new ArrayList<Profile>(profiles.values());
	}

	public Profile getProfile(long id) {
		return profiles.get(id);
	}

	public Profile createProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getId(), profile);
		return profile;

	}

	public Profile updateProfile(Profile profile) {
		if (profiles.size() < 0) {
			return null;
		}
		profiles.put(profile.getId(), profile);
		return profile;
	}

	public Profile removeProfile(long id) {
		return profiles.remove(id);

	}

}
