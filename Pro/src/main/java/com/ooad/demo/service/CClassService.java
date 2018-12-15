package com.ooad.demo.service;

import com.ooad.demo.entity.CClass;
import com.ooad.demo.entity.User;
import com.ooad.demo.mapper.CClassMapper;
import com.ooad.demo.mapper.UserMapper;
import com.ooad.demo.utils.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;


/**
 * @Author: WinstonDeng
 * @Description: OOAD_Course_ManageSystem
 * @Date: Created in 11:32 2018/12/12
 * @Modified by:
 */
@Service
public class CClassService {
    @Autowired
    CClassMapper cClassMapper;

    @Autowired
    UserMapper userMapper;

    /**
     * Description: 通过id找班级
     * @Author: WinstonDeng
     * @Date: 15:05 2018/12/12
     */
    public CClass getCClassById(int id){
        return cClassMapper.findById(id);
    }
    /**
     * Description: 创建班级
     * @Author: WinstonDeng
     * @Date: 11:34 2018/12/12
     */
    public int createCClass(int courseId, CClass cClass) throws Exception {
        //新建记录的主键值 初始化为-1
        int createCClassId=-1;
        try {
            cClass.setCourseId(courseId);
            //注意！这里insert返回只是1/0 表示成功/失败 不是主键
            cClassMapper.insertCClass(cClass);
            //获得主键
            createCClassId=cClass.getId();
        }catch (Exception e){
            throw new Exception("新建班级错误");
        }
        return createCClassId;
    }
    /**
     * Description: 解析名单excel文件 并导入数据库
     * @Author: WinstonDeng
     * @Date: 14:44 2018/12/12
     */
    public boolean transStudentListFileToDataBase(int cclassId,String fileName) throws Exception {
        try {
            String realPath="D://fileloadtest//";
            Set<User> students= ExcelUtils.transExcelToSet(realPath+fileName);
            for(User student
                    :students){
                //如果不存在，则新增，避免重复
                if(userMapper.findByAccount(student.getAccount())==null){
                    //System.out.println(student.getName()+"录入");
                    //student.setCClassId(cclassId);//设置学生所属班级，暂时无
                    userMapper.insertUser(student);
                }
            }
        }catch (Exception e){
            throw new Exception("导入学生名单excel到数据库错误");
        }
        return true;
    }
}
