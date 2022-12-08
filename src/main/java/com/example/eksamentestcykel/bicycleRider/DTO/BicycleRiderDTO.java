package com.example.eksamentestcykel.bicycleRider.DTO;

import com.example.eksamentestcykel.bicycleRider.model.BicycleRider;
import com.example.eksamentestcykel.bicycleTeam.model.BicycleTeam;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;


@NoArgsConstructor
@Data
public class BicycleRiderDTO {

    private final static ModelMapper modelMapper = new ModelMapper();

    String name;
    double totalTime;
    BicycleTeam bicycleTeam;

    private BicycleRiderDTO(String name, double totalTime, BicycleTeam bicycleTeam) {
        this.name = name;
        this.totalTime = totalTime;
        this.bicycleTeam = bicycleTeam;
    }

    public static BicycleRiderDTO mapToDTO(BicycleRider bicycleRider) {
        BicycleRiderDTO dto = modelMapper.map(bicycleRider, BicycleRiderDTO.class);
        //vi parser og sætter setter date i DTO.
        return dto;
    }

    public static BicycleRider mapFromToDTO(BicycleRiderDTO bicycleRiderDTO) {
        BicycleRider bicycleRider = new BicycleRider();

        bicycleRider.setName(bicycleRiderDTO.getName());
        bicycleRider.setTotalTime(bicycleRiderDTO.getTotalTime());
        bicycleRider.setBicycleTeam(bicycleRiderDTO.getBicycleTeam());

        return bicycleRider;
    }


    /*
    *  public static List<WorkDTO> fromWorks(List<Work> works){
        return works.stream()
                .sorted(Comparator.comparing(Work::getReleaseDate).reversed())
                .map(DtoFactory::fromWork)
                .collect(Collectors.toList());*/
}
