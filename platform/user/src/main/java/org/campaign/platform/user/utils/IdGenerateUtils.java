package org.campaign.platform.user.utils;

import org.apache.commons.text.RandomStringGenerator;
import org.yaml.snakeyaml.events.Event;


/**
 * 用来生成一个
 */
public class IdGenerateUtils {
    // 开头数据管理
    private static final String UID = "01";

    private static final int ID_RANDOM_LENGTH = 8;

    private static final int ID_SHARD_KEY_LENGTH = 4;

    private static final RandomStringGenerator gen = new RandomStringGenerator.Builder()
            .withinRange('0', '9')
            .build();

    private static final RandomStringGenerator shardKeyGenerator = new RandomStringGenerator.Builder()
            .withinRange('0', '9')
            .build();

    String s = gen.generate(ID_RANDOM_LENGTH);  // 8位

    public static String generateUId() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(UID)
                .append(gen.generate(ID_RANDOM_LENGTH))
                .append(shardKeyGenerator.generate(ID_SHARD_KEY_LENGTH));
        return stringBuilder.toString();
    }
}
