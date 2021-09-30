package com.practice.domain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Mark Wang
 * @date 2021/9/30
 * 线程池配置
 */
@EnableAsync
@Configuration
public class AsyncConfig {

    /**
     * 普通异步任务管理池
     *
     * @return
     */
    @Bean(name = "asyncCommonExecutor")
    public Executor asyncCommonExecutor() {
        return buildExecutor(300, 600, 30, 6000, "CommonTask-");
    }

    /**
     * 文件处理异步任务管理池
     *
     * @return
     */
    @Bean(name = "asyncFileProcessExecutor")
    public Executor asyncFileProcessExecutor() {
        return buildExecutor(900, 1800, 60, 1000, "FileProcessTask-");
    }

    /**
     * 构建异步任务管理池
     *
     * @param corePoolSize
     * @param maxPoolSize
     * @param keepAliveSeconds
     * @param queueCapacity
     * @param threadNamePrefix
     * @return
     */
    private Executor buildExecutor(int corePoolSize, int maxPoolSize, int keepAliveSeconds, int queueCapacity, String threadNamePrefix) {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 核心线程数
        executor.setCorePoolSize(corePoolSize);
        // 最大线程数
        executor.setMaxPoolSize(maxPoolSize);
        // 线程池维护线程所允许的空闲时间，默认为60s
        executor.setKeepAliveSeconds(keepAliveSeconds);
        // 队列大小
        executor.setQueueCapacity(queueCapacity);
        // 核心线程超时退出，默认为false
        executor.setAllowCoreThreadTimeOut(true);
        // 线程的名称前缀
        executor.setThreadNamePrefix(threadNamePrefix);
        // 等待所有任务完成后再关闭线程池，默认为false
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // 拒绝策略：当线程池已经达到最大线程数的时候，直接在execute方法的调用线程中运行被拒绝的任务。
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 执行初始化
        executor.initialize();
        return executor;
    }

}
