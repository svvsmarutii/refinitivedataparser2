package com.leftlane.refinitivdataparser.service.impl;

import com.jcraft.jsch.*;
import com.leftlane.refinitivdataparser.repository.CRCRepository;
import com.leftlane.refinitivdataparser.repository.entities.CrossRefCodes;
import com.leftlane.refinitivdataparser.service.LGDFService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.Vector;


@Slf4j
@Service
public class LGDFServiceImpl implements LGDFService {

    @Autowired
    CRCRepository crcRepository;
    @Autowired
    DummyService dummyService;
    @Value("${file.path}")
    private String filePath;

    @Value("${ssh.username}")
    private String sshUsername;

    @Value("${ssh.host}")
    private String sshHost;

    @Value("${ssh.pemfile.location}")
    private String sshPemLoc;

    @Value("${ssh.password}")
    private String sshPwd;

    @Value("${ssh.channel}")
    private String sshChannel;


    @Value("${ssh.csv.location}")
    private String csvLoc;



    @Async
    @Override
    public void process() {
        try {

            System.out.println("Attempting to read data from DB");
            List<CrossRefCodes> crossRefCodes = crcRepository.findByStatus(Boolean.TRUE);
            System.out.println("number of records fetched : " + crossRefCodes.size());

            System.out.println("Attempting to read data from file");
            readFile(filePath);

        //    dummyService.longRunning();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dummyService.initiateShutdown(0);
        }
    }

    private void readFile(String filePath) {

        BufferedReader br = null;
        ChannelSftp channelSftp = null;
        String line = "";
        int i = 1;
        try {
            channelSftp = setupJsch();
            channelSftp.connect();
            channelSftp.cd(csvLoc);
            Vector<ChannelSftp.LsEntry> list = (Vector<ChannelSftp.LsEntry>) channelSftp.ls("*.csv");
            for(ChannelSftp.LsEntry entry : list) {
            InputStream is =  channelSftp.get(csvLoc +"/"+ entry.getFilename());
                br = new BufferedReader(new InputStreamReader(is));
                System.out.println("try to read first 4 lines in the file ");
                while ((line = br.readLine()) != null) {
                    System.out.println("line " + i + " : " + line);
                    i++;
                    if (i == 5) break;
                }
            }


        } catch (IOException | JSchException | SftpException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            channelSftp.exit();
        }
    }

    private ChannelSftp setupJsch() throws JSchException {
        JSch.setConfig("StrictHostKeyChecking", "no");
        JSch jsch = new JSch();
        jsch.addIdentity(sshPemLoc);
        Session jschSession = jsch.getSession(sshUsername,sshHost );
      //  jschSession.setPassword(sshPwd);
        jschSession.connect();
        return (ChannelSftp) jschSession.openChannel(sshChannel);
    }
}