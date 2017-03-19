package io.trinadhkoya.github.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.trinadhkoya.github.model.Profile;
import io.trinadhkoya.github.service.ProfileServie;

@Path("/profiles")
public class ProfieResource {

	ProfileServie profileServie = new ProfileServie();

	@GET
	@Produces(MediaType.APPLICATION_JSON)

	public List<Profile> getProfiles() {

		return profileServie.getAllProfiles();
	}

	@GET
	@Path("/{profileId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	public Profile getProfile(@PathParam("profileId") Long profileId) {
		return profileServie.getProfile(profileId);
	}

	@DELETE
	@Path("/{profileId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteProfile(@PathParam("profieId") long id) {
		profileServie.removeProfile(id);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Profile addProfile(Profile profile) {
		profileServie.createProfile(profile);
		return profile;
	}

	@PUT
	@Path("/{profileId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Profile updateProfile(Profile profile, @PathParam("profileId") long id) {
		profile.setId(id);
		profileServie.updateProfile(profile);
		return profile;

	}

}
