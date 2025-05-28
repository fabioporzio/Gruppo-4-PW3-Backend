package service;

import data.model.Badge;
import data.repository.BadgeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import web.model.CreateBadgeRequest;
import web.model.createPerson.CreatePersonRequest;

import java.time.LocalDate;

@ApplicationScoped
public class BadgeService {
    private final BadgeRepository badgeRepository;
    private final BadgeRecordService badgeRecordService;

    public BadgeService(BadgeRepository badgeRepository, BadgeRecordService badgeRecordService) {
        this.badgeRepository = badgeRepository;
        this.badgeRecordService = badgeRecordService;
    }

    public Badge assignBadge(CreatePersonRequest personRequest){
        Badge badge = badgeRepository.findBadgeNotAssigned();
        badge.setAttivata(true);
        badge.setDataInizio(LocalDate.now());
        badge.setDataFine(LocalDate.now());
        badge.setDataRestituzione(LocalDate.now());
        boolean modify = badgeRepository.updateBadgeToStart(badge, personRequest);
        if(modify){
            badgeRecordService.entryStamp(badge);
            return badge;
        }
        return null;
    }

    public boolean removeBadge(CreateBadgeRequest badge){
        return badgeRepository.updateBadgeToEnd(badge);
    }

}
