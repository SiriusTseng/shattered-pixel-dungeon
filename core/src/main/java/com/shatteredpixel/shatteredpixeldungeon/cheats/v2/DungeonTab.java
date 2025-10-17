package com.shatteredpixel.shatteredpixeldungeon.cheats.v2;

import com.shatteredpixel.shatteredpixeldungeon.ui.RedButton;
import com.watabou.noosa.ui.Component;

/**
 * 地牢管理选项卡 - 简化版本
 */
public class DungeonTab extends Component {

    private RedButton placeholder;

    public DungeonTab() {
        super();
    }

    @Override
    protected void createChildren() {
        // 简单的占位符实现
        placeholder = new RedButton("地牢管理功能开发中") {
            @Override
            protected void onClick() {
                // 占位符
            }
        };
        add(placeholder);
    }

    @Override
    protected void layout() {
        placeholder.setRect(x, y, width, 20);
        height = 20;
    }
}