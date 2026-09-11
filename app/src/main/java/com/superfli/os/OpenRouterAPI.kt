package com.superfli.os

object OpenRouterAPI {
    val FREE_MODELS = listOf(
        "google/gemini-2.5-pro:free",
        "qwen/qwen3-coder:free",
        "moonshotai/kimi-k2:free",
        "deepseek/deepseek-v3.1:free"
    )
    const val ENDPOINT = "https://openrouter.ai/api/v1/chat/completions"
}
