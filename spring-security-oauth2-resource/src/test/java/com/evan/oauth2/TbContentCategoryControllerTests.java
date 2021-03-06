package com.evan.oauth2;

import com.evan.oauth2.resource.OAuth2ResourceApplication;
import com.evan.oauth2.resource.domain.TbContent;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

/**
 * 资源访问测试
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OAuth2ResourceApplication.class)
@AutoConfigureMockMvc
public class TbContentCategoryControllerTests {

    @Autowired
    private MockMvc mockMvc;

    /**
     * 获取全部资源
     */
    @Test
    public void testSelectAll() throws Exception {
        int status = this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/user")
                        .header("Authorization", "Bearer 0f89c2aa-f748-41ce-bb87-b96bf7800fd8"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getStatus();
        if (status == 200) {
            log.info("请求成功");
        } else {
            log.info("请求失败，状态码为：{}", status);
        }

        Assert.assertEquals(status, 200);
    }

    /**
     * 获取资源详情
     */
    @Test
    public void testGetById() throws Exception {
        int status = this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/user/view/28")
                        .header("Authorization", "Bearer 0f89c2aa-f748-41ce-bb87-b96bf7800fd8"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getStatus();
        if (status == 200) {
            log.info("请求成功");
        } else {
            log.info("请求失败，状态码为：{}", status);
        }

        Assert.assertEquals(status, 200);
    }

    /**
     * 新增资源
     */
    @Test
    public void testInsert() throws Exception {
        // 由于请求参数使用了 @RequestBody 注解，故需要将参数封装成 JSON 格式
        TbContent tbContent = new TbContent();
        tbContent.setCategoryId(89L);
        tbContent.setTitle("来自 SpringMock 的新增测试");
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        String jsonParams = objectWriter.writeValueAsString(tbContent);

        // 模拟请求
        int status = this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/user/insert")
                        .header("Authorization", "Bearer 0f89c2aa-f748-41ce-bb87-b96bf7800fd8")
                        // 设置使用 JSON 方式传参
                        .contentType(MediaType.APPLICATION_JSON)
                        // 设置 JSON 参数内容
                        .content(jsonParams))
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getStatus();
        if (status == 200) {
            log.info("请求成功");
        } else {
            log.info("请求失败，状态码为：{}", status);
        }

        Assert.assertEquals(status, 200);
    }

    /**
     * 更新资源
     *
     */
    @Test
    public void testUpdate() throws Exception {
        // 由于请求参数使用了 @RequestBody 注解，故需要将参数封装成 JSON 格式
        TbContent tbContent = new TbContent();
        tbContent.setId(43L);
        tbContent.setCategoryId(89L);
        tbContent.setTitle("来自 SpringMock 的编辑测试");
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        String jsonParams = objectWriter.writeValueAsString(tbContent);

        // 模拟请求
        int status = this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/user/update")
                        .header("Authorization", "Bearer 0f89c2aa-f748-41ce-bb87-b96bf7800fd8")
                        // 设置使用 JSON 方式传参
                        .contentType(MediaType.APPLICATION_JSON)
                        // 设置 JSON 参数内容
                        .content(jsonParams))
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getStatus();
        if (status == 200) {
            log.info("请求成功");
        } else {
            log.info("请求失败，状态码为：{}", status);
        }

        Assert.assertEquals(status, 200);
    }

    /**
     * 删除资源
     *
     */
    @Test
    public void testDelete() throws Exception {
        int status = this.mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/user/delete/43")
                        .header("Authorization", "Bearer 0f89c2aa-f748-41ce-bb87-b96bf7800fd8"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getStatus();
        if (status == 200) {
            log.info("请求成功");
        } else {
            log.info("请求失败，状态码为：{}", status);
        }

        Assert.assertEquals(status, 200);
    }


}