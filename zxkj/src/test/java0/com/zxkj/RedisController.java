package com.zxkj;

import com.zxkj.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
 
@RequestMapping("/redisUtil")
@RestController
public class RedisController {
 
    @Autowired
    private RedisUtil redisUtil;
 
    /**
     * redis添加测试
     * @param redisKey
     * @param redisValue
     */
    @RequestMapping("addRedis")
    @ResponseBody
    public String addRedis(String redisKey,String redisValue){
        redisUtil.set(redisKey,redisValue);
        return "addRedis添加redis数据成功";
    }
 
    /**
     * redis key获取value测试
     * @param redisKey
     */
    @RequestMapping("getValueByRedis")
    @ResponseBody
    public String getValueByRedis(String redisKey){
        Object obj = redisUtil.get(redisKey);
        if(obj!=null){
            System.out.print((String) obj);
            return (String) obj;
        }else {
            return null;
        }
    }
 
//    /**
//     * 案例1
//     * 可以增加热搜，但是在取热搜词的时候，Map排序问题
//     *
//     * redis key获取value测试   模拟热搜 增加1
//     * @param hotWord
//     */
//    @RequestMapping("updateValueByHotWord")
//    @ResponseBody
//    public String updateValueByHotWord(String hotWord){
//        Map<String,String> obj = redisUtil.hmget("mapHot");
//        if(obj==null){
//            Map<String ,String> mapHot = new HashMap<String ,String>();
//            mapHot.put(hotWord,"1");
//            redisUtil.hmset("mapHot",mapHot);
//        }else {
//            if(obj.get(hotWord)==null){
//                obj.put(hotWord,"1");
//            }else {
//                obj.put(hotWord,Integer.parseInt(obj.get(hotWord))+1+"");
//            }
//            redisUtil.hmset("mapHot",obj);
//        }
//
//        return "热搜已更新";
//    }

}
