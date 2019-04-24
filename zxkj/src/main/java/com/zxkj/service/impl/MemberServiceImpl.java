package com.zxkj.service.impl;

import com.zxkj.entity.Member;
import com.zxkj.dao.MemberDao;
import com.zxkj.service.MemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZhuXingKeJi
 * @since 2019-04-22
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberDao, Member> implements MemberService {

}
