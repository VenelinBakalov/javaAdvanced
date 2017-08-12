package app.terminal;

import app.dto.accessories.AccessoryWrapperImportDto;
import app.dto.cameras.CameraImportJsonDto;
import app.dto.lens.LensImportJsonDto;
import app.dto.photographers.LandscapePhotographersJsonDto;
import app.dto.photographers.PhotographerImportJsonDto;
import app.dto.workshops.*;
import app.entities.*;
import app.serialize.api.Serializer;
import app.services.api.AccessoriesService;
import app.services.api.CamerasService;
import app.services.api.LensService;
import app.services.api.WorkshopsService;
import app.services.impl.PhotographersServiceImpl;
import app.utils.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Venelin on 6.8.2017 г..
 */
@Component
public class Terminal implements CommandLineRunner {

    private static final String LENSES_INPUT_JSON = "/files/json/input/lenses.json";
    private static final String CAMERAS_INPUT_JSON = "/files/json/input/cameras.json";
    private static final String PHOTOGRAPHERS_INPUT_JSON = "/files/json/input/photographers.json";
    private static final String ACCESSORIES_INPUT_XML = "/files/xml/input/accessories.xml";
    private static final String WORKSHOPS_INPUT_XML = "/files/xml/input/workshops.xml";

    private static final String PHOTOGRAPHERS_LANDSCAPE_OUTPUT_JSON = "src/main/resources/files/json/output/landscape_photographers.json";
    private static final String WORKSHOPS_BY_LOCATION_OUTPUT_XML = "src/main/resources/files/xml/output/workshops_by_location.xml";


    @Autowired
    @Qualifier("JsonSerializer")
    private Serializer jsonSerializer;

    @Autowired
    @Qualifier("XmlSerializer")
    private Serializer xmlSerializer;

    @Autowired
    private PhotographersServiceImpl photographersService;

    @Autowired
    private WorkshopsService workshopsService;

    @Autowired
    private LensService lensService;

    @Autowired
    private CamerasService camerasService;

    @Autowired
    private AccessoriesService accessoriesService;

    @Override
    public void run(String... strings) throws Exception {

        /*
        IMPORTS
         */

//        importLensesFromJson();
//        importCamerasJson();
//        importPhotographersJson();
//        importAccessoriesXml();
        importWorkshopsXml();

        /*
        EXPORTS
         */

//        exportLandscapePhotographers();
//        exportLocationsWithWorkshops();
    }

    private void importWorkshopsXml() {
        WorkshopWrapperXmlImportDto workshopWrapper = xmlSerializer.deserialize(WorkshopWrapperXmlImportDto.class, WORKSHOPS_INPUT_XML);
        for (WorkshopXmlImportDto workshopXmlImportDto : workshopWrapper.getWorkshopXmlImportDtos()) {
            Workshop workshop = DTOConverter.convert(workshopXmlImportDto, Workshop.class);
            this.workshopsService.add(workshop);
        }
    }

    private void importAccessoriesXml() {
        AccessoryWrapperImportDto accessoryWrapperDto = this.xmlSerializer.deserialize(AccessoryWrapperImportDto.class, ACCESSORIES_INPUT_XML);
        List<Accessory> accessories = DTOConverter.convert(accessoryWrapperDto.getAccessories(), Accessory.class);
        this.accessoriesService.addAll(accessories);
    }

    private void importPhotographersJson() {
        PhotographerImportJsonDto[] photographerDtos = this.jsonSerializer.deserialize(PhotographerImportJsonDto[].class, PHOTOGRAPHERS_INPUT_JSON);
        for (PhotographerImportJsonDto photographerDto : photographerDtos) {
            this.photographersService.add(photographerDto);
        }
    }

    private void importCamerasJson() {
        CameraImportJsonDto[] camerasImportDtos = this.jsonSerializer.deserialize(CameraImportJsonDto[].class, CAMERAS_INPUT_JSON);

        for (CameraImportJsonDto camerasImportDto : camerasImportDtos) {
            BasicCamera camera = null;

            if ("DSLR".equals(camerasImportDto.getType())) {
                camera = DTOConverter.convert(camerasImportDto, DSLRCamera.class);
                this.camerasService.add(camera);
            } else if ("Mirrorless".equals(camerasImportDto.getType())) {
                camera = DTOConverter.convert(camerasImportDto, MirrorlessCamera.class);
                this.camerasService.add(camera);
            }
        }
    }

    private void importLensesFromJson() {
        LensImportJsonDto[] lensImportJsonDto = this.jsonSerializer.deserialize(LensImportJsonDto[].class, LENSES_INPUT_JSON);
        List<Lens> lenses = DTOConverter.convert(Arrays.asList(lensImportJsonDto), Lens.class);
        this.lensService.addAll(lenses);
    }

    private void exportLocationsWithWorkshops() {
        Map<String, List<Workshop>> workshopsByLocation = this.workshopsService.findWorkshopsByLocation();
        LocationsWrapperXmlExportDto locationsWrapperXmlExportDto = new LocationsWrapperXmlExportDto();
        for (String location : workshopsByLocation.keySet()) {
            List<Workshop> workshops = workshopsByLocation.get(location);
            List<WorkshopExportXmlDto> workshopDtos = DTOConverter.convert(workshops, WorkshopExportXmlDto.class);

            LocationXmlExportDto locationXmlExportDto = new LocationXmlExportDto();
            locationXmlExportDto.setName(location);
            locationXmlExportDto.setWorkshops(workshopDtos);

            locationsWrapperXmlExportDto.addLocation(locationXmlExportDto);
        }

        this.xmlSerializer.serialize(locationsWrapperXmlExportDto, WORKSHOPS_BY_LOCATION_OUTPUT_XML);
    }

    private void exportLandscapePhotographers() {
        List<Photographer> landscapePhotographers = this.photographersService.findLandscapePhotographers();
        List<LandscapePhotographersJsonDto> landscapePhotographerDtos = DTOConverter.convert(landscapePhotographers, LandscapePhotographersJsonDto.class);

        this.jsonSerializer.serialize(landscapePhotographerDtos, PHOTOGRAPHERS_LANDSCAPE_OUTPUT_JSON);
    }

}
