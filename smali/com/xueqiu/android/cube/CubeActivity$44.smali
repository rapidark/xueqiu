.class final Lcom/xueqiu/android/cube/CubeActivity$44;
.super Ljava/lang/Object;
.source "CubeActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xueqiu/android/cube/CubeActivity;
.end annotation


# instance fields
.field final synthetic a:Lcom/xueqiu/android/cube/CubeActivity;


# direct methods
.method constructor <init>(Lcom/xueqiu/android/cube/CubeActivity;)V
    .locals 0

    .prologue
    .line 2017
    iput-object p1, p0, Lcom/xueqiu/android/cube/CubeActivity$44;->a:Lcom/xueqiu/android/cube/CubeActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    const/4 v3, 0x2

    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 2020
    iget-object v0, p0, Lcom/xueqiu/android/cube/CubeActivity$44;->a:Lcom/xueqiu/android/cube/CubeActivity;

    iget-object v0, v0, Lcom/xueqiu/android/cube/CubeActivity;->j:Landroid/widget/Button;

    invoke-static {v0, v1, v3}, Lcom/xueqiu/android/cube/CubeActivity;->a(Landroid/widget/Button;ZI)V

    .line 2021
    iget-object v0, p0, Lcom/xueqiu/android/cube/CubeActivity$44;->a:Lcom/xueqiu/android/cube/CubeActivity;

    iget-object v0, v0, Lcom/xueqiu/android/cube/CubeActivity;->k:Landroid/widget/Button;

    invoke-static {v0, v2, v1}, Lcom/xueqiu/android/cube/CubeActivity;->a(Landroid/widget/Button;ZI)V

    .line 2022
    iget-object v0, p0, Lcom/xueqiu/android/cube/CubeActivity$44;->a:Lcom/xueqiu/android/cube/CubeActivity;

    iget-object v0, v0, Lcom/xueqiu/android/cube/CubeActivity;->p:Landroid/widget/Button;

    const/4 v1, 0x3

    invoke-static {v0, v2, v1}, Lcom/xueqiu/android/cube/CubeActivity;->a(Landroid/widget/Button;ZI)V

    .line 2023
    iget-object v0, p0, Lcom/xueqiu/android/cube/CubeActivity$44;->a:Lcom/xueqiu/android/cube/CubeActivity;

    invoke-static {v0, v3}, Lcom/xueqiu/android/cube/CubeActivity;->b(Lcom/xueqiu/android/cube/CubeActivity;I)V

    .line 2024
    new-instance v0, Lcom/xueqiu/android/common/model/SNBEvent;

    const/16 v1, 0x579

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/xueqiu/android/common/model/SNBEvent;-><init>(II)V

    .line 2025
    const-string v1, "symbol"

    iget-object v2, p0, Lcom/xueqiu/android/cube/CubeActivity$44;->a:Lcom/xueqiu/android/cube/CubeActivity;

    invoke-static {v2}, Lcom/xueqiu/android/cube/CubeActivity;->a(Lcom/xueqiu/android/cube/CubeActivity;)Lcom/xueqiu/android/cube/model/Cube;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xueqiu/android/cube/model/Cube;->getSymbol()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/xueqiu/android/common/model/SNBEvent;->addProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 2026
    const-string v1, "period"

    const-string v2, "\u6700\u8fd13\u4e2a\u6708"

    invoke-virtual {v0, v1, v2}, Lcom/xueqiu/android/common/model/SNBEvent;->addProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 2053
    invoke-static {}, Lcom/xueqiu/android/base/i;->a()Lcom/xueqiu/android/base/h;

    move-result-object v1

    .line 2027
    invoke-virtual {v1, v0}, Lcom/xueqiu/android/base/h;->a(Lcom/xueqiu/android/common/model/SNBEvent;)V

    .line 2028
    return-void
.end method
