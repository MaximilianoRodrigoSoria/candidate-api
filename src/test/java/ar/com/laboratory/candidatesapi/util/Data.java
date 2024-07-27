package ar.com.laboratory.candidatesapi.util;

import ar.com.laboratory.candidatesapi.domain.CandidateRequest;
import ar.com.laboratory.candidatesapi.domain.CandidateResponse;
import ar.com.laboratory.candidatesapi.infrastructure.entity.Candidate;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Data {

    public static final Candidate CANDIDATE_1 = new Candidate(1L, "John Doe", "john.doe@example.com", "Male", new BigDecimal("60000"), new Date(), true, new Date(), "Full-time");
    public static final Candidate CANDIDATE_2 = new Candidate(2L, "Jane Smith", "jane.smith@example.com", "Female", new BigDecimal("65000"), new Date(), true, new Date(), "Part-time");
    public static final Candidate CANDIDATE_3 = new Candidate(3L, "Alice Johnson", "alice.johnson@example.com", "Female", new BigDecimal("70000"), new Date(), true, new Date(), "Contractor");
    public static final Candidate CANDIDATE_4 = new Candidate(4L, "Bob Brown", "bob.brown@example.com", "Male", new BigDecimal("55000"), new Date(), true, new Date(), "Intern");
    public static final Candidate CANDIDATE_5 = new Candidate(5L, "Charlie Black", "charlie.black@example.com", "Male", new BigDecimal("60000"), new Date(), true, new Date(), "Freelance");

    public static final List<Candidate> CANDIDATE_LIST = List.of(CANDIDATE_1, CANDIDATE_2, CANDIDATE_3, CANDIDATE_4, CANDIDATE_5);

    public static final CandidateResponse CANDIDATE_RESPONSE = new CandidateResponse(1L, "John Doe", "john.doe@example.com", "Male", new BigDecimal("60000"), true,new Date(),  new Date(), "Full-time");

    public static final CandidateRequest CANDIDATE_REQUEST = new CandidateRequest("John Doe", "john.doe@example.com", "Male", new BigDecimal("60000"), "Full-time");
}