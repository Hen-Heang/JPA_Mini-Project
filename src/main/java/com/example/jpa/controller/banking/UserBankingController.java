package com.example.jpa.controller.banking;


import com.example.jpa.controller.AbstractRestController;
import com.example.jpa.payload.banking.user.UserCreateRequest;
import com.example.jpa.payload.banking.user.UserUpdateRequest;
import com.example.jpa.service.banking.user.UserBankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserBankingController extends AbstractRestController {

    private final UserBankingService userBankingService;
    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserCreateRequest userCreateRequest) {
        userBankingService.createUser(userCreateRequest);
        return ok();
    }

    @PatchMapping("/{uuid}")
    public Object updateUserByUuid(@PathVariable("uuid") String uuid, @RequestBody UserUpdateRequest userUpdateRequest) {
        userBankingService.updateUserByUuid(uuid, userUpdateRequest);
        return ok();
    }

    @GetMapping("/all")
    public Object getAllUser(
            @RequestParam(name = "page_number", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(name = "page_size", defaultValue = "10", required = false) Integer sizeNumber
    ){
        Pageable pageable = PageRequest.of(pageNumber, sizeNumber);
        return userBankingService.getAllUser(pageable);
    }

}
