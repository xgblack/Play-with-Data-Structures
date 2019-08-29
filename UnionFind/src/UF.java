/**
 * @author 小光
 * @date 2019/8/29 17:02
 * Copyright(C),2018-2019,https://blog.xgblack.cn
 * interfaceName: UF
 * description:
 */
public interface UF {
    int getSize();

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);
}
