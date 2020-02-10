剑指offer 
一些排序查找算法
leetcode等等 
持续不断的更新



资源调优：
资源池分档：
分实时流和批处理

档位：
实时流：1C512M、1C512M、2C512M、3c512m,
1c1g、3c1g、1c2g、2c2g、3c2g  2c4g  6c4g   3c3g
3c6g 4c8g 8c8g   12c8g  8c16g  12c16g  12c24g  18c36g  24c48g


1c2g:
executors:1
cores:1
memory:2048
spark.executor.memoryOverhead:512
spark.yarn.executor.memoryOverhead:512
spark.sql.shuffle.partitions:12
spark.default.parallesism:12
spark.buffer.pageSize:4M
maxFailedTimes:5
maxWaitingBatch:10

2c2g:
executors:2
cores:2
memory:1024
spark.executor.memoryOverhead:1024
spark.yarn.executor.memoryOverhead:1024
spark.sql.shuffle.partitions:36
spark.default.parallesism:36
maxFailedTimes:5
maxWaitingBatch:10


批处理：1c512m    2c1g  2c2g    2c3g  3c3g  4c3g  6c3g 2c4g
6c4g  3c6g 4c6g  9c6g  4c8g  12c9g  6c12g  9c12g 9c18g  18c18g   18c36g
15c9g  18c12g 4c48g  24c18g 50c60g



1c512m:
executors:1
cores:1
memory:512
driver.memory.mb:1024
spark.executor.memoryOverhead:512
spark.yarn.executor.memoryOverhead:512
spark.sql.shuffle.partitions:12
spark.default.parallesism:12
spark.buffer.pageSize:4M


9c18g:
executors:3
cores:3
memory:6144
driver.memory.mb:1536
spark.executor.memoryOverhead:1024
spark.yarn.executor.memoryOverhead:1024
spark.sql.shuffle.partitions:48
spark.default.parallesism:48



18c18g:
executors:3
cores:6
memory:6144
driver.memory.mb:1536
spark.executor.memoryOverhead:2048
spark.yarn.executor.memoryOverhead:2048
spark.sql.shuffle.partitions:150
spark.default.parallesism:150







