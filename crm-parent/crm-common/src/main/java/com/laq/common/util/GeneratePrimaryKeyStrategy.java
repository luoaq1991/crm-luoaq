package com.laq.common.util;

import java.util.UUID;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;

/**
 * 主键生成 策略
 *
 * @author Mr.YongGan.Zhang
 */
public final class GeneratePrimaryKeyStrategy {

    private static final Logger LOGGER = Logger.getLogger(GeneratePrimaryKeyStrategy.class);

    private GeneratePrimaryKeyStrategy() {
    }

    private static Lock locks = new ReentrantLock();

    private static Integer MAX_CURRENT_LIMITE = 10;

    // 订单编号的 暴力限流
    private static final Semaphore SEMAPHORE = new Semaphore(MAX_CURRENT_LIMITE);

    /**
     * 生成订单编号
     *
     * @return String
     */
    public static String getOrderGeneratePrimaryKey() {
        try {
            SEMAPHORE.acquire();
            if (locks.tryLock(2, TimeUnit.SECONDS)) {
                int machineId = 1;  // 最大支持1-9个集群机器部署
                int hashCodeV = UUID.randomUUID().toString().hashCode();
                if (hashCodeV < 0) { // 有可能是负数
                    hashCodeV = -hashCodeV;
                }
                // 0 代表前面补充0
                // 4 代表长度为4
                // d 代表参数为正数型
                return machineId + String.format("%015d", hashCodeV);
            }
        } catch (InterruptedException e) {
            LOGGER.error("订单生成策略 生成订单编号失败 ", e);
        } finally {
            locks.unlock();
            // 限流释放
            SEMAPHORE.release();
        }
        return null;
    }

    /**
     * 生成 购物车
     *
     * @return
     */
    public static String getShoppingCartGeneratePrimaryKey() {
        return authCustomerCode();
    }

    /**
     * 生成用户登录令牌
     *
     * @return
     */
    public static synchronized String authCustomerCode() {
        String code = UUID.randomUUID().toString().replaceAll("-", "");
        return code;
    }

    public static void main(String[] args) {
        System.out.println(authCustomerCode());
    }
}