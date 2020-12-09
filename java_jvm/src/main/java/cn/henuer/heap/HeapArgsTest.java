package cn.henuer.heap;

/**
 * 测试堆空间的常用jvm参数
 *  -XX:+PrintFlagsInitial 查看所有的参数的默认初始值
 *  -XX:+PrintFlagsFinal  查看所有的参数的最终值（可能会存在修改，不再是初始值）
 *     具体查看某个参数的指令： jps :查看当前运行的进程
 *                             jinfo -flag 参数名 进程ID
 *
 *  -Xms: 初始堆内存大小 (默认物理内存1/64)
 *  -Xmx: 最大堆内存大小（默认物理内存1/4）
 *  -Xmn: 设置新生代的大小（初始值及最大值）
 *  -XX:NewRatio 设置新生代一老年代再对结构的占比
 *  -XX:SurvivorRatio 设置新生代中农Eden和S0、S1空间的比例
 *  -XX:MaxTenuringThreshold 设置新生代垃圾的最大年龄
 *  -XX:+PrintGCDetails: 输出详细的GC处理日志
 *     打印简要的信息： -XX:PrintGC  -verbose:gc
 *  -XX:HandlePromotionFailure:  是否设置空间分配担保
 */
public class HeapArgsTest {
    public static void main(String[] args) {
      byte [] bytes=new byte[1024*10];
    }
}
