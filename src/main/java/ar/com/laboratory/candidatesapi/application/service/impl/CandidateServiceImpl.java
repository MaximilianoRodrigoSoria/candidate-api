package ar.com.laboratory.candidatesapi.application.service.impl;

import ar.com.laboratory.candidatesapi.application.repository.CandidateRepository;
import ar.com.laboratory.candidatesapi.application.service.CandidateService;
import ar.com.laboratory.candidatesapi.domain.CandidateRequest;
import ar.com.laboratory.candidatesapi.domain.CandidateResponse;
import ar.com.laboratory.candidatesapi.infrastructure.entity.Candidate;
import ar.com.laboratory.candidatesapi.infrastructure.exceptions.IdNotFoundException;
import ar.com.laboratory.candidatesapi.infrastructure.exceptions.SaveException;
import ar.com.laboratory.candidatesapi.infrastructure.mapper.CandidateMapper;
import ar.com.laboratory.candidatesapi.infrastructure.util.Constants;
import ar.com.laboratory.candidatesapi.infrastructure.util.annotations.CommonsLogging;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@AllArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    private  final CandidateRepository candidateRepository;

    @Override
    @CommonsLogging(tag = Constants.TAG_CANDIDATE_SERVICE)
    public CandidateResponse created(CandidateRequest request) {
        Candidate candidate = null;

            candidate = CandidateMapper.INSTANCE.toCandidate(request);
            candidate.setActive(true);
            candidate.setCreatedAt(new Date());
            candidate.setUpdatedAt(new Date());
            candidate = saveEntity(candidate);

        return CandidateMapper.INSTANCE.toResponse(candidate);
    }

    @Override
    @CommonsLogging(tag = Constants.TAG_CANDIDATE_SERVICE)
    public CandidateResponse read(Long aLong) {
        return CandidateMapper.INSTANCE.toResponse(findById(aLong));
    }

@Override
@CommonsLogging(tag = Constants.TAG_CANDIDATE_SERVICE)
public CandidateResponse update(CandidateRequest request, Long id) {
    var candidate = findById(id);
    if (Objects.isNull(candidate)) {
        throw new IdNotFoundException("Candidate not found with id: " + id);
    }
    candidate.setName(request.getName());
    candidate.setEmail(request.getEmail());
    candidate.setGender(request.getGender());
    candidate.setExpectedSalary(request.getExpectedSalary());
    candidate.setActive(true);
    candidate.setTypeOfContract(request.getTypeOfContract());
    candidate.setUpdatedAt(new Date());
    var savedCandidate = saveEntity(candidate);
    return CandidateMapper.INSTANCE.toResponse(savedCandidate);
}

    @Override
    @CommonsLogging(tag = Constants.TAG_CANDIDATE_SERVICE)
    public void delete(Long aLong) {
            var candidate = findById(aLong);
            candidate.setActive(false);
            this.saveEntity(candidate);
    }

    @Override
    @CommonsLogging(tag = Constants.TAG_CANDIDATE_SERVICE)
    public List<CandidateResponse> readAll() {
        return candidateRepository.findByActiveTrue().stream().map(CandidateMapper.INSTANCE::toResponse).toList();
    }


    private Candidate findById(Long id) {
        var candidate = candidateRepository.findByIdAndActiveTrue(id);
        if(candidate.isPresent()){
            return candidate.get();
        }
        throw  new IdNotFoundException(Constants.CANDIDATE_TABLE);
    }

    private Candidate saveEntity(Candidate candidate) {
        Candidate candidateSaved = null;
        try {
            candidateSaved = candidateRepository.save(candidate);
        } catch (Exception e) {
            throw new SaveException(Constants.CANDIDATE_TABLE);
        }
        return candidateSaved;
    }
}
