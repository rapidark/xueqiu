.class final Landroid/support/v7/widget/x;
.super Ljava/lang/Object;
.source "RecyclerView.java"

# interfaces
.implements Landroid/support/v7/widget/w;


# instance fields
.field final synthetic a:Landroid/support/v7/widget/RecyclerView;


# direct methods
.method private constructor <init>(Landroid/support/v7/widget/RecyclerView;)V
    .locals 0

    .prologue
    .line 7805
    iput-object p1, p0, Landroid/support/v7/widget/x;->a:Landroid/support/v7/widget/RecyclerView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroid/support/v7/widget/RecyclerView;B)V
    .locals 0

    .prologue
    .line 7805
    invoke-direct {p0, p1}, Landroid/support/v7/widget/x;-><init>(Landroid/support/v7/widget/RecyclerView;)V

    return-void
.end method


# virtual methods
.method public final a(Landroid/support/v7/widget/ao;)V
    .locals 3

    .prologue
    .line 7809
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/widget/ao;->a(Z)V

    .line 7810
    iget-object v0, p0, Landroid/support/v7/widget/x;->a:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, p1, Landroid/support/v7/widget/ao;->a:Landroid/view/View;

    invoke-static {v0, v1}, Landroid/support/v7/widget/RecyclerView;->e(Landroid/support/v7/widget/RecyclerView;Landroid/view/View;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p1}, Landroid/support/v7/widget/ao;->n()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 7811
    iget-object v0, p0, Landroid/support/v7/widget/x;->a:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, p1, Landroid/support/v7/widget/ao;->a:Landroid/view/View;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/support/v7/widget/RecyclerView;->removeDetachedView(Landroid/view/View;Z)V

    .line 7813
    :cond_0
    return-void
.end method

.method public final b(Landroid/support/v7/widget/ao;)V
    .locals 2

    .prologue
    .line 7817
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/widget/ao;->a(Z)V

    .line 7818
    invoke-virtual {p1}, Landroid/support/v7/widget/ao;->p()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 7819
    iget-object v0, p0, Landroid/support/v7/widget/x;->a:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, p1, Landroid/support/v7/widget/ao;->a:Landroid/view/View;

    invoke-static {v0, v1}, Landroid/support/v7/widget/RecyclerView;->e(Landroid/support/v7/widget/RecyclerView;Landroid/view/View;)Z

    .line 7821
    :cond_0
    return-void
.end method

.method public final c(Landroid/support/v7/widget/ao;)V
    .locals 2

    .prologue
    .line 7825
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/widget/ao;->a(Z)V

    .line 7826
    invoke-virtual {p1}, Landroid/support/v7/widget/ao;->p()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 7827
    iget-object v0, p0, Landroid/support/v7/widget/x;->a:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, p1, Landroid/support/v7/widget/ao;->a:Landroid/view/View;

    invoke-static {v0, v1}, Landroid/support/v7/widget/RecyclerView;->e(Landroid/support/v7/widget/RecyclerView;Landroid/view/View;)Z

    .line 7829
    :cond_0
    return-void
.end method

.method public final d(Landroid/support/v7/widget/ao;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 7833
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/support/v7/widget/ao;->a(Z)V

    .line 7861
    iget-object v0, p1, Landroid/support/v7/widget/ao;->g:Landroid/support/v7/widget/ao;

    if-eqz v0, :cond_0

    iget-object v0, p1, Landroid/support/v7/widget/ao;->h:Landroid/support/v7/widget/ao;

    if-nez v0, :cond_0

    .line 7862
    iput-object v2, p1, Landroid/support/v7/widget/ao;->g:Landroid/support/v7/widget/ao;

    .line 7863
    const/16 v0, -0x41

    .line 8711
    iget v1, p1, Landroid/support/v7/widget/ao;->i:I

    .line 7863
    invoke-virtual {p1, v0, v1}, Landroid/support/v7/widget/ao;->a(II)V

    .line 7867
    :cond_0
    iput-object v2, p1, Landroid/support/v7/widget/ao;->h:Landroid/support/v7/widget/ao;

    .line 7868
    invoke-virtual {p1}, Landroid/support/v7/widget/ao;->p()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 7869
    iget-object v0, p0, Landroid/support/v7/widget/x;->a:Landroid/support/v7/widget/RecyclerView;

    iget-object v1, p1, Landroid/support/v7/widget/ao;->a:Landroid/view/View;

    invoke-static {v0, v1}, Landroid/support/v7/widget/RecyclerView;->e(Landroid/support/v7/widget/RecyclerView;Landroid/view/View;)Z

    .line 7871
    :cond_1
    return-void
.end method
