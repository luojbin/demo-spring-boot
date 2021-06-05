package com.luojbin.demo.spring.boot.dependencies;

import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyTraceRepository implements HttpTraceRepository {
    static List<HttpTrace> repo = new ArrayList();

    @Override
    public List<HttpTrace> findAll() {
        return repo;
    }

    @Override
    public void add(HttpTrace trace) {
        System.out.println("新增一条记录");
        if (repo.size() > 3) {
            System.out.println("记录太多了, 归零");
            repo.clear();
        }
        repo.add(trace);
    }
}
