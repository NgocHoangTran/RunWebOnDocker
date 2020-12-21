package com.dtdm.qlsv.controller;

import com.dtdm.qlsv.model.Lop;
import com.dtdm.qlsv.repository.LopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/lop")
public class LopController {
    @Autowired
    private LopRepository lopRepository;

    @GetMapping("/lops")
    public List<Lop> getAllLops(){
        return lopRepository.findAll();
    }

    @GetMapping("/lops/{id}")
    public ResponseEntity<Lop> getLopId(@PathVariable(value = "id") Integer lopId)
            throws ResourceNotFoundException {
        Lop lop=lopRepository.findById(lopId).
                orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy lớp với mã :: " + lopId));
        return ResponseEntity.ok().body(lop);
    }

    @PostMapping("/lops")
    public Lop createLop(@Valid @RequestBody Lop lop){
        return lopRepository.save(lop);
    }

    @PutMapping("/lops/{id}")
    public ResponseEntity<Lop> updateLop(@PathVariable(value = "id") Integer lopId,
                                           @Valid @RequestBody Lop lopDetails) throws ResourceNotFoundException{
        Lop lop=lopRepository.findById(lopId).
                orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy lớp với mã :: " + lopId));
        lop.setMa_Lop(lopDetails.getMa_Lop());
        lop.setTen_Lop(lopDetails.getTen_Lop());
        lop.setKhoa(lopDetails.getKhoa());
        final Lop updateLop=lopRepository.save(lop);
        return ResponseEntity.ok(updateLop);
    }

    @DeleteMapping("/lops/{id}")
    public Map<String, Boolean> deleteLop(@PathVariable(value = "id") Integer lopId)
            throws ResourceNotFoundException{
        Lop lop=lopRepository.findById(lopId).
                orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy lớp với mã :: " + lopId));
        lopRepository.delete(lop);
        Map<String, Boolean> response= new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return  response;
    }
}
