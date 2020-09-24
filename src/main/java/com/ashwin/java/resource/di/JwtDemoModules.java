package com.ashwin.java.resource.di;

import com.ashwin.java.data.repositoryimpl.StudentRepositoryImpl;
import com.ashwin.java.data.source.StudentDao;
import com.ashwin.java.data.source.local.StudentLocal;
import com.ashwin.java.domain.repository.StudentRepository;
import com.ashwin.java.domain.service.StudentService;
import com.ashwin.java.resource.api.StudentResource;
import com.ashwin.java.resource.dto.StudentMapper;
import org.glassfish.jersey.internal.inject.AbstractBinder;

import javax.inject.Singleton;

public class JwtDemoModules extends AbstractBinder {
    @Override
    protected void configure() {
        bind(StudentLocal.class).to(StudentDao.class).in(Singleton.class);
        bind(StudentRepositoryImpl.class).to(StudentRepository.class).in(Singleton.class);
        bind(StudentService.class).to(StudentService.class).in(Singleton.class);

        bind(StudentMapper.class).to(StudentMapper.class).in(Singleton.class);

        // Resources
        bind(StudentResource.class).to(StudentResource.class).in(Singleton.class);
    }
}
