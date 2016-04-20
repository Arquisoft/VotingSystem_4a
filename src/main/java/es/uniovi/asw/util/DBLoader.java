package es.uniovi.asw.util;

import java.sql.Time;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import es.uniovi.asw.dbupdate.repositories.CandidatureRepository;
import es.uniovi.asw.dbupdate.repositories.DistrictRepository;
import es.uniovi.asw.dbupdate.repositories.ElectionCallRepository;
import es.uniovi.asw.dbupdate.repositories.ElectionRepository;
import es.uniovi.asw.dbupdate.repositories.RegionRepository;
import es.uniovi.asw.dbupdate.repositories.VoteRepository;
import es.uniovi.asw.dbupdate.repositories.VoterRepository;
import es.uniovi.asw.dbupdate.repositories.VotingPlaceRepository;
import es.uniovi.asw.model.District;
import es.uniovi.asw.model.Election;
import es.uniovi.asw.model.ElectionCall;
import es.uniovi.asw.model.ReferendumOption;
import es.uniovi.asw.model.Region;
import es.uniovi.asw.model.Vote;
import es.uniovi.asw.model.Voter;
import es.uniovi.asw.model.VotingPlace;
import es.uniovi.asw.model.types.ElectionDateTime;

@Component
public class DBLoader implements ApplicationListener<ContextRefreshedEvent> {
	
	private Logger log = LoggerFactory.getLogger(DBLoader.class);
	
	@Autowired
	private ElectionCallRepository electionCallRepository;

	@Autowired
	private ElectionRepository electionRepository;

	@Autowired
	private RegionRepository regionRepository;

	@Autowired
	private DistrictRepository districtRepository;

	@Autowired
	private CandidatureRepository candidatureRepository;

	@Autowired
	private VotingPlaceRepository placeRepository;

	@Autowired
	private VoterRepository voterRepository;
	
	@Autowired
	private VoteRepository voteRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		
		// Create a new election call
		
		ElectionCall electionCall = new ElectionCall("Referendum de Prueba", "Referendum de Independencia de Asturias");
		electionCallRepository.save(electionCall);
		log.info("Saved electionCall - id: " + electionCall.getId());
		
		// Create a new election
		
		Election election = new Election();

		election.setName("Congreso 2017");
		election.setDescription("Elecciones al Congreso 2017");

		ElectionDateTime electionDateTime = new ElectionDateTime();
		Calendar calendar = Calendar.getInstance();

		Time start = new Time(calendar.getTimeInMillis());
		Time end = new Time(calendar.getTimeInMillis() + 1000000);

		electionDateTime.setStartTime(start);
		electionDateTime.setEndTime(end);
		election.setElectionDateTime(electionDateTime);
		
		// Link the election call with the election
		
		electionRepository.save(election);
		electionCall.addElection(election);
		
		log.info("Saved election - id: " + election.getId());
		
		// Create and link the region with it's election
		Region region = new Region();
		region.setName("España");
		
		regionRepository.save(region);
		election.addRegion(region);
		log.info("Saved region - id: " + region.getId());
		
		// Create a new district and link	
		District district = new District();
		district.setName("Estado Español");
		
		districtRepository.save(district);
		region.addDistrict(district);
		log.info("Saved district - id: " + district.getId());
		
		ReferendumOption referendumOption = new ReferendumOption();
		referendumOption.setOption("Sí");
		
		candidatureRepository.save(referendumOption);
		district.addCandidature(referendumOption);
		
		VotingPlace votingPlace = new VotingPlace();
		votingPlace.setName("Colegio La Ería");
		
		placeRepository.save(votingPlace);
		district.addVotingPlace(votingPlace);
		
		Voter ivan = new Voter("Iván", "ivan@eii.es", "11111111A", 1L, null);
		Voter ricardo = new Voter("Ricardo", "ricardo@eii.es", "22222222A", 2L, null);
		
		ricardo.setVotingPlace(votingPlace);
		
		voterRepository.save(ivan);
		
		voteRepository.save(new Vote(ricardo.getVotingPlace(), referendumOption));
		ricardo.setVoted(true);
		voterRepository.save(ricardo);
				
		
		
		
		
	}

}
