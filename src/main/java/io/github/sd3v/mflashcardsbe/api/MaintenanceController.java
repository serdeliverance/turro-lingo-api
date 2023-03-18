package io.github.sd3v.mflashcardsbe.api;

import io.github.sd3v.mflashcardsbe.service.MaintenanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/maintenance")
public class MaintenanceController {

    private final MaintenanceService maintenanceService;

    @PostMapping("/addIdToFlashcards")
    public void addIdToFlashcards() {
        maintenanceService.addIdToFlashcards();
    }
}
