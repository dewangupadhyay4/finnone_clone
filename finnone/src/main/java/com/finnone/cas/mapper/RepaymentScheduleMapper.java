package com.finnone.cas.mapper;

import com.finnone.cas.dto.RepaymentScheduleDto;
import com.finnone.cas.entity.RepaymentSchedule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class RepaymentScheduleMapper {
	
	public RepaymentSchedule toEntity(RepaymentScheduleDto dto) {
		RepaymentSchedule repaymentSchedule=new RepaymentSchedule();
		repaymentSchedule.setId(dto.getId());
		repaymentSchedule.setApplicationNumber(dto.getApplicationNumber());
		repaymentSchedule.setEmiAmount(dto.getEmiAmount());
		repaymentSchedule.setInterestComponent(dto.getInterestComponent());
		repaymentSchedule.setLocalDate(dto.getLocalDate());
		repaymentSchedule.setPrincipalComponent(dto.getPrincipalComponent());
		repaymentSchedule.setRemainingPrincipal(dto.getRemainingPrincipal());
		repaymentSchedule.setTenure(dto.getTenure());
		repaymentSchedule.setInstallmentNumber(dto.getInstallmentNumber());
		repaymentSchedule.setInstallmentDate(dto.getInstallmentDate());
		return repaymentSchedule;
	}

	public RepaymentScheduleDto toDto(RepaymentSchedule schedule) {
		RepaymentScheduleDto repaymentScheduleDto=new RepaymentScheduleDto();
		repaymentScheduleDto.setId(schedule.getId());
		repaymentScheduleDto.setApplicationNumber(schedule.getApplicationNumber());
		repaymentScheduleDto.setEmiAmount(schedule.getEmiAmount());
		repaymentScheduleDto.setInterestComponent(schedule.getInterestComponent());
		repaymentScheduleDto.setLocalDate(schedule.getLocalDate());
		repaymentScheduleDto.setPrincipalComponent(schedule.getPrincipalComponent());
		repaymentScheduleDto.setRemainingPrincipal(schedule.getRemainingPrincipal());
		repaymentScheduleDto.setTenure(schedule.getTenure());
		repaymentScheduleDto.setInstallmentNumber(schedule.getInstallmentNumber());
		repaymentScheduleDto.setInstallmentDate(schedule.getInstallmentDate());
		return repaymentScheduleDto;
	}
	
	public List<RepaymentScheduleDto> toList(List<RepaymentSchedule> schedules){
		List<RepaymentScheduleDto> dtos=new ArrayList<>();
		for(RepaymentSchedule schedule:schedules) {
			RepaymentScheduleDto dto=toDto(schedule);
			dtos.add(dto);
		}
		return dtos;
	}
	
}
