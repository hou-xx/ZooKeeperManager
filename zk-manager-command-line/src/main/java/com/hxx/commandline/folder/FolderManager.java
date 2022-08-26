package com.hxx.commandline.folder;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <ul>
 * <li>功能说明：</li>
 * <li>作者：Tal on 2022\7\20 0020 22:54 </li>
 * </ul>
 */
public class FolderManager {
    private final static List<String> FOLDERS = new ArrayList<>();

    public static String concatFolders(String... paths) {
        StringBuilder ss = new StringBuilder();
        if (!CollectionUtils.isEmpty(FOLDERS)) {
            for (String folder : FOLDERS) {
                if (!folder.startsWith("/")) {
                    ss.append("/");
                }
                ss.append(folder);
            }
        }
        if (paths.length == 0) {
            return ss.toString();
        }
        for (String path : paths) {
            if (!path.startsWith("/")) {
                ss.append("/");
            }
            ss.append(path);
        }
        return ss.toString();
    }

    public static String push(String folder) {
        if (StringUtils.isBlank(folder)) {
            return concatFolders();
        }
        FOLDERS.add(folder);
        return concatFolders();
    }


}
