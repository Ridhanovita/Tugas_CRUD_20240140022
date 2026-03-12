package com.example.ktpapi.service.impl;

import com.example.ktpapi.dto.KtpDto;
import com.example.ktpapi.entity.Ktp;
import com.example.ktpapi.mapper.KtpMapper;
import com.example.ktpapi.repository.KtpRepository;
import com.example.ktpapi.service.KtpService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KtpServiceImpl implements KtpService {

    private final KtpRepository repository;

    public KtpServiceImpl(KtpRepository repository){
        this.repository = repository;
    }

    public KtpDto create(KtpDto dto){

        Ktp ktp = KtpMapper.toEntity(dto);

        ktp = repository.save(ktp);

        return KtpMapper.toDto(ktp);
    }

    public List<KtpDto> findAll(){

        return repository.findAll()
                .stream()
                .map(KtpMapper::toDto)
                .collect(Collectors.toList());
    }

    public KtpDto findById(Integer id){

        Ktp ktp = repository.findById(id).orElseThrow();

        return KtpMapper.toDto(ktp);
    }

    public KtpDto update(Integer id,KtpDto dto){

        Ktp ktp = repository.findById(id).orElseThrow();

        ktp.setNomorKtp(dto.getNomorKtp());
        ktp.setNamaLengkap(dto.getNamaLengkap());
        ktp.setAlamat(dto.getAlamat());
        ktp.setTanggalLahir(dto.getTanggalLahir());
        ktp.setJenisKelamin(dto.getJenisKelamin());

        ktp = repository.save(ktp);

        return KtpMapper.toDto(ktp);
    }

    public void delete(Integer id){

        repository.deleteById(id);
    }

}