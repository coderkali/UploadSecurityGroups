package com.gm.asm.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.gm.asm.dto.CsvDTO;
import com.gm.asm.request.AddIdentityRequest;
import com.gm.asm.request.ManageGroupRequest;
import com.gm.asm.response.ManageGroupResponse;
import com.gm.asm.response.userid.UserResponse;
import com.gm.asm.service.AddIdentitiesI;
import com.gm.asm.service.ManageGroupI;
import com.gm.asm.service.ReadCSVService;
import com.gm.asm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


@Service
public class ReadCSVImpl implements ReadCSVService {


    @Value("${app.file.name}")
    private String fileName;

    @Autowired
    ManageGroupI manageGroupI;

    @Autowired
    AddIdentitiesI addIdentitiesI;

    @Autowired
    UserService userService;


    @Override
    public CsvDTO readCSV() {
        InputStream is = TypeReference.class.getResourceAsStream(fileName);
        parseCsvFile(is);
        return null;
    }



    public void parseCsvFile(InputStream is) {
        BufferedReader fileReader = null;
        CSVParser csvParser = null;
        try {
            fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            csvParser = new CSVParser(fileReader,
                    CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                ManageGroupRequest getAsmId = new ManageGroupRequest(csvRecord.get("Emp_ID"));
                String asmId = manageGroupI.manageGroup(getAsmId);


                ManageGroupRequest getGroupId = new ManageGroupRequest(csvRecord.get("DPG_Groups"));
                String groupId = manageGroupI.manageGroup(getAsmId);


                AddIdentityRequest addAsmIdentityRequest = new AddIdentityRequest();
                addAsmIdentityRequest.setGroupsToJoinJson(asmId);
                addAsmIdentityRequest.setExistingUsersJson(groupId);
                addIdentitiesI.addIdentity(addAsmIdentityRequest);


                String userId = csvRecord.get("usr_id");
                String userResponse =userService.getUserByUserName(userId);

                if(userResponse!=null){
                    AddIdentityRequest addGroupIdentityRequest = new AddIdentityRequest();
                    addGroupIdentityRequest.setGroupsToJoinJson(groupId);
                    addGroupIdentityRequest.setExistingUsersJson(userResponse);
                    addIdentitiesI.addIdentity(addGroupIdentityRequest);
                }
            }
        } catch (Exception e) {
            System.out.println("Reading CSV Error!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                csvParser.close();
            } catch (IOException e) {
                System.out.println("Closing fileReader/csvParser Error!");
                e.printStackTrace();
            }
        }
    }
}
