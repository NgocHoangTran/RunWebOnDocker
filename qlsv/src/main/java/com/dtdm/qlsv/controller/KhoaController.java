package com.dtdm.qlsv.controller;

import com.dtdm.qlsv.model.Khoa;
import com.dtdm.qlsv.repository.KhoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/khoa")
public class KhoaController {
    @Autowired
    private KhoaRepository khoaRepository;

    @GetMapping("/khoas")
    public List<Khoa> getAllkhoas(){
        return khoaRepository.findAll();
    }

    @GetMapping("/khoas/{id}")
    public ResponseEntity<Khoa> getKhoaId(@PathVariable(value = "id") Integer khoaId)
        throws ResourceNotFoundException{
        Khoa khoa=khoaRepository.findById(khoaId).
                orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy khoa với mã :: " + khoaId));
        return ResponseEntity.ok().body(khoa);
    }

    @PostMapping("/khoas")
    public Khoa createKhoa(@Valid @RequestBody Khoa khoa){
        return khoaRepository.save(khoa);
    }

    @PutMapping("/khoas/{id}")
    public ResponseEntity<Khoa> updateKhoa(@PathVariable(value = "id") Integer khoaId,
                                           @Valid @RequestBody Khoa khoaDetails) throws ResourceNotFoundException{
        Khoa khoa=khoaRepository.findById(khoaId).
                orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy khoa với mã :: " + khoaId));
        khoa.setMa_Khoa(khoaDetails.getMa_Khoa());
        khoa.setTen_Khoa(khoaDetails.getTen_Khoa());
        final Khoa updateKhoa=khoaRepository.save(khoa);
        return ResponseEntity.ok(updateKhoa);
    }

    @DeleteMapping("/khoas/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Integer khoaId)
            throws ResourceNotFoundException{
        Khoa khoa=khoaRepository.findById(khoaId).
                orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy khoa với mã :: " + khoaId));
        khoaRepository.delete(khoa);
        Map<String, Boolean> response= new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return  response;
    }
}
