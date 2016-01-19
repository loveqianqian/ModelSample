package com.myloverqian.io;

import java.io.File;

/**
 * Created by dzw on 2016/1/19.
 */
public interface FileProcessor {
    void processorByLine(String filePath, LineProcessor lineProcessor);

    void processorByLine(File file, LineProcessor lineProcessor);
}
