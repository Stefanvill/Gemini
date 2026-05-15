package se.iths.stefan.demogooglelogin.service;

import org.springframework.stereotype.Service;
import se.iths.stefan.demogooglelogin.model.QNA;
import se.iths.stefan.demogooglelogin.repository.QNARepository;

import java.util.List;

@Service
public class QNAService {
    private final QNARepository repository;

    public QNAService(QNARepository repository) {
        this.repository = repository;
    }

    public void save(String question, String answer) {
        QNA qna = new QNA();
        qna.setQuestion(question);
        qna.setAnswer(answer);
        repository.save(qna);
    }

    public List<QNA> displayAll() {
        return repository.findAll();
    }
}
