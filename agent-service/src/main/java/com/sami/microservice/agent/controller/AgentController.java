package com.sami.microservice.agent.controller;

import com.sami.microservice.agent.entities.Agent;
import com.sami.microservice.agent.service.IServiceAgent;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agent")
@AllArgsConstructor
public class AgentController {
    private   IServiceAgent iServiceAgent;
    @GetMapping("/find/{id}")
    public ResponseEntity<Agent> findAgent(@PathVariable("id") int id){
        Agent a= iServiceAgent.findAgentById(id);
        if (a==null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(a);
        }
    }
    @PostMapping("/add")
    public ResponseEntity<Agent>addAgent(@RequestBody Agent a){
        Agent ag =iServiceAgent.createAgent(a);
        return ResponseEntity.ok(ag);
    }
    @PutMapping("/update")
    public ResponseEntity<Agent>updateAgent(@RequestBody Agent a){
        Agent ag = iServiceAgent.updateAgent(a);
        return ResponseEntity.ok(ag);
    }
    @DeleteMapping("/delete/{id}")
    public void  deleteAgent(@PathVariable("id") int id){
        iServiceAgent.deleteAgent(id);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Agent>> findAll(){
        return ResponseEntity.ok(iServiceAgent.findAllAgent());
    }

}
