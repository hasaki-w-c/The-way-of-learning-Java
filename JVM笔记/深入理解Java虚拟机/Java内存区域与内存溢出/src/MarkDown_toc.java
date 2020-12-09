import com.github.houbb.markdown.toc.core.impl.AtxMarkdownToc;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/24 16:12
 */
public class MarkDown_toc {
    public static void main(String[] args) {
        AtxMarkdownToc.newInstance().genTocFile("G:\\JVM笔记\\深入理解Java虚拟机\\Java内存区域与内存溢出\\Java内存区域与内存溢出异常.md");

        AtxMarkdownToc.newInstance()
                .charset("GBK")
                .write(true)
                .subTree(true);
    }
}
