package com.garbo.service.impl;

import com.garbo.entity.Blog;
import com.garbo.mapper.BlogMapper;
import com.garbo.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author garbo
 * @since 2021-01-11
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
