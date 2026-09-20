package com.hejazi.distributed_payment_gateway.common.rateLimit;

public interface RateLimiter {
    RateLimitResult check(String key, int maxRequestAllowed, long windowSeconds);
}
