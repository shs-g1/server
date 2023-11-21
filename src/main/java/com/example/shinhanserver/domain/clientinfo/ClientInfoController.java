package com.example.shinhanserver.domain.clientinfo;

import com.example.shinhanserver.domain.workspace.WorkspaceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@RequestMapping("/clientInfo")
@Controller
public class ClientInfoController {

  private final ClientInfoService clientInfoService;


  @GetMapping
  public ResponseEntity<ClientInfoDto> getWorkSpace(@RequestParam Long clientId) {
    return ResponseEntity.status(HttpStatus.OK).body(clientInfoService.getClientInformation(clientId));
  }

}
