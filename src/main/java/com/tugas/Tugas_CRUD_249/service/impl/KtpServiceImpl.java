package com.tugas.Tugas_CRUD_249.service.impl;




import com.tugas.Tugas_CRUD_249.dto.KtpDto;
import com.tugas.Tugas_CRUD_249.mapper.KtpMapper;
import com.tugas.Tugas_CRUD_249.model.KtpEntity;
import com.tugas.Tugas_CRUD_249.repository.KtpRepository;
import com.tugas.Tugas_CRUD_249.service.KtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KtpServiceImpl implements KtpService {

    @Autowired
    private KtpRepository ktpRepository;

    @Autowired
    private KtpMapper ktpMapper;

    @Override
    public KtpDto createKtp(KtpDto ktpDto) {
        // Error Handling: Cek apakah nomor KTP sudah ada
        if (ktpRepository.findByNomorKtp(ktpDto.getNomorKtp()).isPresent()) {
            throw new RuntimeException("Nomor KTP sudah terdaftar!");
        }
        KtpEntity entity = ktpMapper.toEntity(ktpDto);
        KtpEntity savedEntity = ktpRepository.save(entity);
        return ktpMapper.toDto(savedEntity);
    }

    @Override
    public List<KtpDto> getAllKtp() {
        return ktpRepository.findAll().stream()
                .map(ktpMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public KtpDto getKtpById(Integer id) {
        KtpEntity entity = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data KTP tidak ditemukan dengan ID: " + id));
        return ktpMapper.toDto(entity);
    }

    @Override
    public KtpDto updateKtp(Integer id, KtpDto ktpDto) {
        KtpEntity existingEntity = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan, gagal update."));

        // Update field
        existingEntity.setNamaLengkap(ktpDto.getNamaLengkap());
        existingEntity.setAlamat(ktpDto.getAlamat());
        existingEntity.setTanggalLahir(ktpDto.getTanggalLahir());
        existingEntity.setJenisKelamin(ktpDto.getJenisKelamin());

        // Nomor KTP biasanya tidak diubah, tapi jika diubah perlu validasi lagi.
        // Di sini kita asumsikan tetap atau ditangani sesuai kebutuhan.
        existingEntity.setNomorKtp(ktpDto.getNomorKtp());

        KtpEntity updatedEntity = ktpRepository.save(existingEntity);
        return ktpMapper.toDto(updatedEntity);
    }

    @Override
    public void deleteKtp(Integer id) {
        if (!ktpRepository.existsById(id)) {
            throw new RuntimeException("Gagal menghapus, ID tidak ditemukan.");
        }
        ktpRepository.deleteById(id);
    }
}