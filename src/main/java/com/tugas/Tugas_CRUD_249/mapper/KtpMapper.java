package com.tugas.Tugas_CRUD_249.mapper;



import com.tugas.Tugas_CRUD_249.dto.KtpDto;
import com.tugas.Tugas_CRUD_249.model.KtpEntity;
import org.springframework.stereotype.Component;

@Component
public class KtpMapper {

    public KtpDto toDto(KtpEntity entity) {
        KtpDto dto = new KtpDto();
        dto.setId(entity.getId());
        dto.setNomorKtp(entity.getNomorKtp());
        dto.setNamaLengkap(entity.getNamaLengkap());
        dto.setAlamat(entity.getAlamat());
        dto.setTanggalLahir(entity.getTanggalLahir());
        dto.setJenisKelamin(entity.getJenisKelamin());
        return dto;
    }

    public KtpEntity toEntity(KtpDto dto) {
        KtpEntity entity = new KtpEntity();
        entity.setId(dto.getId());
        entity.setNomorKtp(dto.getNomorKtp());
        entity.setNamaLengkap(dto.getNamaLengkap());
        entity.setAlamat(dto.getAlamat());
        entity.setTanggalLahir(dto.getTanggalLahir());
        entity.setJenisKelamin(dto.getJenisKelamin());
        return entity;
    }
}