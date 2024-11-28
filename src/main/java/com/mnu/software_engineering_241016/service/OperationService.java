package com.mnu.software_engineering_241016.service;

import com.mnu.software_engineering_241016.dto.CalDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OperationService {
    public int operation(CalDTO calDTO) {
        return calDTO.getFirstNo() + calDTO.getSecondNo();
    }
}
