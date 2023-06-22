package model;

import common.CheckMeritListDTO;

public class CheckMeritListFactory {
    public static CheckMeritListDTO createCheckMeritListDTO(CheckMeritListDTO dto) {
        // Create and return CheckMeritList instance
        CheckMeritListDTO meritList = new CheckMeritListDTO();
        meritList.setStudentID(dto.getStudentID());
        meritList.setStudentName(dto.getStudentName());
        meritList.setCourse(dto.getCourse());
        meritList.setMatricMarks(dto.getMatricMarks());
        meritList.setFscMarks(dto.getFscMarks());
        meritList.setTestMarks(dto.getTestMarks());
        meritList.setPercentage(dto.getPercentage());
        meritList.setRank(dto.getRank());
        
        return meritList;
    }
}
