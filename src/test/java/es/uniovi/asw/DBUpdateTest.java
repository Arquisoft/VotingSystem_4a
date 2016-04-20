package es.uniovi.asw;

import es.uniovi.asw.Application;
import es.uniovi.asw.dbupdate.ports.GetParametersP;
import es.uniovi.asw.dbupdate.ports.GetVoterP;
import es.uniovi.asw.dbupdate.ports.InsertP;
import es.uniovi.asw.dbupdate.ports.RegisterVoteP;
import es.uniovi.asw.model.*;
import es.uniovi.asw.model.types.ElectionDateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * DBUpdateTest
 * Created by ivan on 19/04/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@Transactional
public class DBUpdateTest {

	@Autowired
	private InsertP insertP;

	@Autowired
	private RegisterVoteP registerVoteP;

	@Autowired
	private GetVoterP getVoterP;

	@Autowired
	private GetParametersP getParametersP;

	private ElectionCall electionCall;
	private Election election;
	private Region region;
	private District district;
	private ReferendumOption referendumOption;
	private VotingPlace votingPlace;
	private Voter voter;

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void insertElectionCall() throws Exception {
		electionCall = new ElectionCall();

		electionCall.setName("Referendum de Prueba");
		electionCall.setDescription("Referendum de Independencia de Asturias");

		assertNull(electionCall.getId());
		insertP.insertElectionCall(electionCall);
		assertTrue(electionCall.getId() > 0);
	}

	private Election createElection() {
		Election election = new Election();

		election.setName("Congreso 2017");
		election.setDescription("Elecciones al Congreso 2017");

		assertNull(election.getId());

		ElectionDateTime electionDateTime = new ElectionDateTime();
		Calendar calendar = Calendar.getInstance();

		Time start = new Time(calendar.getTimeInMillis());
		Time end = new Time(calendar.getTimeInMillis() + 1000000);

		electionDateTime.setStartTime(start);
		electionDateTime.setEndTime(end);
		election.setElectionDateTime(electionDateTime);

		return election;
	}

	@Test
	public void insertElection() throws Exception {
		insertElectionCall();
		election = createElection();

		assertNull(election.getId());
		insertP.insertElection(electionCall.getId(), election);

		assertTrue(electionCall.getElections().size() > 0);
		assertTrue(election.getId() > 0);
	}

	@Test
	public void insertRegion() throws Exception {
		insertElection();
		region = new Region();

		region.setName("España");
		insertP.insertRegion(election.getId(), region);

		assertTrue(election.getRegions().size() > 0);
		assertTrue(region.getId() > 0);
	}

	@Test
	public void insertDistrict() throws Exception {
		insertRegion();
		district = new District();

		district.setName("Estado Español");
		insertP.insertDistrict(region.getId(), district);

		assertTrue(region.getDistricts().size() > 0);
		assertTrue(district.getId() > 0);
	}

	@Test
	public void insertReferendumOption() throws Exception {
		insertDistrict();
		referendumOption = new ReferendumOption();

		referendumOption.setOption("Sí");
		insertP.insertReferendumOption(district.getId(), referendumOption);

		assertTrue(district.getCandidatures().size() > 0);
		assertTrue(referendumOption.getId() > 0);
	}

	@Test
	public void insertVotingPlace() throws Exception {
		insertDistrict();
		votingPlace = new VotingPlace();

		votingPlace.setName("Colegio La Ería");
		insertP.insertVotingPlace(district.getId(), votingPlace);

		assertTrue(district.getVotingPlaces().size() > 0);
		assertTrue(votingPlace.getId() > 0);
	}

	@Test
	public void insertVoter() throws Exception {
		insertVotingPlace();
		voter = new Voter();

		voter.setName("Iván");
		voter.setEmail("ivan@eii.es");
		voter.setNif("11111111A");
		voter.setCode(1L);

		insertP.insertVoter(votingPlace.getId(), voter);

		assertTrue(votingPlace.getVoters().size() > 0);
		assertTrue(voter.getId() > 0);
	}

	@Test
	public void insertVote() throws Exception {
		insertVotingPlace();

		referendumOption = new ReferendumOption();
		referendumOption.setOption("No");

		insertP.insertReferendumOption(district.getId(), referendumOption);
		assertTrue(district.getCandidatures().size() > 0);
		assertTrue(referendumOption.getId() > 0);

		registerVoteP.insertVote(referendumOption.getId(), votingPlace.getId());
		assertTrue(votingPlace.getVotes().size() > 0);
	}

	@Test
	public void getVoter() throws Exception {
		insertVoter();

		voter = getVoterP.getVoter(voter.getId());
		assertNotNull(voter);
	}

	@Test
	public void registerVoter() throws Exception {
		insertVoter();

		voter = getVoterP.getVoter(voter.getId());
		assertNotNull(voter);

		assertFalse(voter.hasVoted());
		voter = registerVoteP.registerVoter(voter.getNif());
		assertTrue(voter.hasVoted());
	}

	@Test
	public void getElectionCalls() throws Exception {
		assertNotNull(getParametersP.getElectionCalls());
	}

	@Test
	public void getElections() throws Exception {
		insertElection();
		assertNotNull(getParametersP.getElections(electionCall.getId()));
	}

	@Test
	public void getRegions() throws Exception {
		insertRegion();
		assertNotNull(getParametersP.getRegions(election.getId()));
	}

	@Test
	public void getDistricts() throws Exception {
		insertDistrict();
		assertNotNull(getParametersP.getDistricts(region.getId()));
	}

	@Test
	public void getCandidatures() throws Exception {
		insertReferendumOption();
		assertNotNull(getParametersP.getCandidatures(district.getId()));
	}

	@Test
	public void getVotingPlaces() throws Exception {
		insertVotingPlace();
		assertNotNull(getParametersP.getVotingPlaces(district.getId()));
	}

}