package org.java.deal.download.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.shiro.SecurityUtils;
import org.java.base.common.controller.BaseController;
import org.java.base.system.UserConstant;
import org.java.base.vo.user.AuthUser;
import org.java.deal.download.entity.FileRecord;
import org.java.deal.download.service.DownloadService;
import org.java.util.FTPUtil;
import org.java.util.WebUtil;
import org.java.util.file.DownloadUtil;
import org.java.util.json.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * 博客类型
 *
 * @author 周家伟
 * @date 2016-7-19
 */
@Controller
@RequestMapping("/admin/download")
public class DownloadController extends BaseController {

    @Resource
    private DownloadService downloadService;

    @Resource
    private FTPUtil ftpUtil;

    /**
     * 跳转到下载首页
     *
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        return "admin/file/download";
    }

    /**
     * 加载文件下载类型列表
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/list", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String list(HttpServletRequest request) {
        PageHelper.startPage(1, 10);
        JSONObject jsonObject = new JSONObject();
        Map<String, Object> queryMap = WebUtil.getParameterMap(request);
        List<FileRecord> list = downloadService.list(queryMap);
        PageInfo<FileRecord> pageInfo = new PageInfo<FileRecord>(list);
        jsonObject.put("rows", JsonUtil.parseToJson(pageInfo.getList()));
        jsonObject.put("total", pageInfo.getTotal());
        return jsonObject.toString();
    }

    /**
     * 后台日志下载
     *
     * @param response
     * @throws Exception
     */
    @RequestMapping("/download")
    public void downloadImage(HttpServletResponse response, String fileName) throws Exception {
        AuthUser authUser = (AuthUser) SecurityUtils.getSubject().getPrincipal();
        FTPClient ftp = new FTPClient();
        ftp.connect(ftpUtil.getFtpHost(), ftpUtil.getFtpPort());
        if (!ftp.login(ftpUtil.getFtpUserName(), ftpUtil.getFtpPassword())) {
            ftp.disconnect();
        } else {
            ftp.enterLocalPassiveMode();
            //路径是绝对路径,不包含ip地址的
            String fileUrl = UserConstant.USER_IMAGE_PATH + "/" + authUser.getUsername() + "/" + fileName;
            InputStream is = ftp.retrieveFileStream(new String(fileUrl.getBytes("UTF-8"), "ISO-8859-1"));
            DownloadUtil downloadUtil = new DownloadUtil();
            downloadUtil.prototypeDownload(is, fileName, response);
        }
    }
}