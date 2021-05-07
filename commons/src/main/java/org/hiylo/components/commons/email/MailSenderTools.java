/*
 * Copyright(c) 2016 - 2020, Clouds Studio Holding Limited. All rights reserved.
 * Project : components
 * File : MailSenderTools.java
 * Date : 7/22/20, 12:51 AM
 * Author : Hsi Chu
 * Contact : hiylo@live.com
 */

package org.hiylo.components.commons.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Component
@ConditionalOnProperty(name = "spring.mail.enable", havingValue = "true")
public class MailSenderTools {
    @Resource
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String from;

    /**
     * 发送纯文本邮件.
     *
     * @param to      目标email 地址
     * @param subject 邮件主题
     * @param text    纯文本内容
     */
    public void sendMail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }

    /**
     * 发送邮件并携带附件.
     * 请注意 from 、 to 邮件服务器是否限制邮件大小
     *
     * @param to             目标email 地址
     * @param subject        邮件主题
     * @param text           纯文本内容
     * @param multipartFiles 文件
     */
    public void sendMailWithMultipartFile(String to, String subject, String text, List<MultipartFile> multipartFiles) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text);
        for (MultipartFile multipartFile : multipartFiles) {
            helper.addAttachment(multipartFile.getName(), multipartFile);
        }
        javaMailSender.send(mimeMessage);
    }

    /**
     * 发送邮件并携带附件.
     * 请注意 from 、 to 邮件服务器是否限制邮件大小
     *
     * @param to      目标email 地址
     * @param subject 邮件主题
     * @param text    纯文本内容
     * @param files   文件
     */
    public void sendMailWithFile(String to, String subject, String text, List<File> files) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text);
        for (File file : files) {
            helper.addAttachment(file.getName(), file);
        }
        javaMailSender.send(mimeMessage);
    }

    /**
     * 发送邮件并携带附件.
     * 请注意 from 、 to 邮件服务器是否限制邮件大小
     *
     * @param to        目标email 地址
     * @param subject   邮件主题
     * @param text      纯文本内容
     * @param filePaths 文件
     */
    public void sendMailWithAttachment(String to, String subject, String text, List<String> filePaths) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text);
        for (String filePath : filePaths) {
            File attachment = new File(filePath);
            helper.addAttachment(attachment.getName(), attachment);
        }
        javaMailSender.send(mimeMessage);
    }

    /**
     * 发送富文本邮件.
     *
     * @param to        目标email 地址
     * @param subject   邮件主题
     * @param text      纯文本内容
     * @param filePaths 附件的路径 当然你可以改写传入文件
     */
    public void sendRichMailWithAttachment(String to, String subject, String text, Map<String, String> filePaths) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text, true);
        // 图片占位写法  如果图片链接写入模板 注释下面这一行
        Iterator<String> keys = filePaths.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            helper.addInline(key, new FileSystemResource(filePaths.get(key)));
        }
        javaMailSender.send(mimeMessage);
    }

    /**
     * 发送富文本邮件.
     *
     * @param to        目标email 地址
     * @param subject   邮件主题
     * @param text      纯文本内容
     * @param multipartFiles 文件
     */
    public void sendRichMailWithMultipartFile(String to, String subject, String text, Map<String, MultipartFile> multipartFiles) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text, true);
        // 图片占位写法  如果图片链接写入模板 注释下面这一行
        Iterator<String> keys = multipartFiles.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            helper.addInline(key, multipartFiles.get(key), helper.getFileTypeMap().getContentType(key));
        }
        javaMailSender.send(mimeMessage);
    }
}
