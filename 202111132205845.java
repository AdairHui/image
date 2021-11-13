package me.zhengjie.modules.sports.controller;

import lombok.extern.slf4j.Slf4j;
import me.zhengjie.annotation.Log;
import me.zhengjie.dto.Dto;
import me.zhengjie.service.FileUploadService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 图片上传
 * </p>
 *
 * @author: zeng
 * @since: 2020-07-29
 */
@Slf4j
@RestController
public class FileUploadController {

    @Resource
    private FileUploadService fileUploadService;

    /**
     * 后台管理图片上传
     *
     * @param response
     * @param request
     * @return
     */
    @Log("图片上传")
    @RequestMapping(value = "/api/file/uploadFile", method = RequestMethod.POST)
    public Dto apiUpload(HttpServletResponse response, HttpServletRequest request) throws IOException {
        List filePaths = fileUploadService.uploadify( request, response);
        return Dto.returnResult(null).setData("list", filePaths);
    }
}
