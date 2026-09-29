package com.example.projetoexpo.ui.screens.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.FactCheck
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.projetoexpo.data.datastore.UserPreferencesRepository

private data class AreaOption(
    val title: String,
    val categoryBadge: String,
    val description: String,
    val icon: ImageVector
)

@Composable
fun OnboardingScreen(
    userPreferencesRepository: UserPreferencesRepository,
    onNavigateToDashboard: () -> Unit,
    viewModel: OnboardingViewModel = viewModel(
        factory = OnboardingViewModel.provideFactory(userPreferencesRepository)
    )
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val focusManager = LocalFocusManager.current
    val scrollState = rememberScrollState()

    val availableAreas = listOf(
        AreaOption(
            title = "Desenvolvimento Front-end Web",
            categoryBadge = "Programação & Web",
            description = "HTML, CSS, JavaScript e React para construir sites, páginas responsivas e aplicações web.",
            icon = Icons.Default.Code
        ),
        AreaOption(
            title = "Desenvolvimento Back-end & APIs",
            categoryBadge = "Servidores & Banco de Dados",
            description = "Lógica de servidores, modelagem de bancos SQL e criação de APIs REST seguras.",
            icon = Icons.Default.Storage
        ),
        AreaOption(
            title = "Desenvolvimento Mobile Android",
            categoryBadge = "Aplicativos & Kotlin",
            description = "Criação de aplicativos nativos para Android com Kotlin, Jetpack Compose e MVVM.",
            icon = Icons.Default.PhoneAndroid
        ),
        AreaOption(
            title = "Suporte Técnico & Redes TI",
            categoryBadge = "Infraestrutura & Suporte",
            description = "Hardware, sistemas operacionais (Windows/Linux), redes locais e atendimento helpdesk.",
            icon = Icons.Default.Computer
        ),
        AreaOption(
            title = "Análise de Dados & BI",
            categoryBadge = "Dados & Inteligência",
            description = "Excel Avançado, consultas SQL e dashboards no Power BI para tomada de decisões.",
            icon = Icons.Default.BarChart
        ),
        AreaOption(
            title = "Design UI/UX & Produto",
            categoryBadge = "Design & Criatividade",
            description = "Pesquisa com usuários, prototipagem no Figma e criação de interfaces modernas.",
            icon = Icons.Default.Palette
        ),
        AreaOption(
            title = "Qualidade de Software (QA)",
            categoryBadge = "Testes & Qualidade",
            description = "Planos de teste, validação de APIs com Postman e introdução a testes automatizados.",
            icon = Icons.AutoMirrored.Filled.FactCheck
        ),
        AreaOption(
            title = "Cibersegurança & SOC N1",
            categoryBadge = "Segurança & Defesa",
            description = "Proteção de redes, análise de vulnerabilidades, monitoramento e fundamentos da LGPD.",
            icon = Icons.Default.Security
        ),
        AreaOption(
            title = "DevOps & Cloud Computing",
            categoryBadge = "Nuvem & Automação",
            description = "Administração Linux, Docker, fundamentos de AWS e automação de pipelines CI/CD.",
            icon = Icons.Default.CloudSync
        ),
        AreaOption(
            title = "Marketing Digital & Redes Sociais",
            categoryBadge = "Comunicação & Vendas",
            description = "Copywriting, criação de conteúdo no Canva, tráfego pago (Meta Ads) e métricas.",
            icon = Icons.Default.Campaign
        )
    )

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            Surface(
                color = MaterialTheme.colorScheme.surface,
                tonalElevation = 6.dp,
                shadowElevation = 8.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 16.dp)
                ) {
                    Button(
                        onClick = {
                            focusManager.clearFocus()
                            viewModel.saveAndProceed(onNavigateToDashboard)
                        },
                        enabled = uiState.isFormValid && !uiState.isLoading,
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = MaterialTheme.colorScheme.onPrimary
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(54.dp)
                    ) {
                        if (uiState.isLoading) {
                            CircularProgressIndicator(
                                color = MaterialTheme.colorScheme.onPrimary,
                                modifier = Modifier.size(24.dp)
                            )
                        } else {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "Gerar Minha Trilha de Carreira",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                    contentDescription = null,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(scrollState)
                .padding(horizontal = 24.dp, vertical = 20.dp)
        ) {
            // 1. Badge ODS 8
            Surface(
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = RoundedCornerShape(50),
                modifier = Modifier.padding(bottom = 12.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Navigation,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimaryContainer,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "ODS 8 • Trabalho Decente & Futuro",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // 2. Cabeçalho
            Text(
                text = "GPS de Carreira",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "Mapeie suas habilidades e descubra um caminho prático para sua entrada no mercado de trabalho.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(22.dp))

            // 3. Campo de Nome
            Text(
                text = "Como você gostaria de ser chamado?",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = uiState.userName,
                onValueChange = { viewModel.onNameChanged(it) },
                placeholder = { Text("Ex: Gabriel Silva") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Words,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = { focusManager.clearFocus() }
                ),
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outlineVariant
                )
            )

            Spacer(modifier = Modifier.height(22.dp))

            // 4. Seletor de Modo: Escolha Direta vs Quiz IA
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                FilterChip(
                    selected = uiState.activeTab == OnboardingTab.DIRECT_SELECTION,
                    onClick = { viewModel.onTabChanged(OnboardingTab.DIRECT_SELECTION) },
                    label = { Text("📋 Escolha no Catálogo") },
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.weight(1f)
                )

                FilterChip(
                    selected = uiState.activeTab == OnboardingTab.AI_QUIZ,
                    onClick = { viewModel.onTabChanged(OnboardingTab.AI_QUIZ) },
                    label = { Text("✨ Recomendador IA") },
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 5. Conteúdo da Aba Ativa
            if (uiState.activeTab == OnboardingTab.AI_QUIZ) {
                // ABA DO QUIZ DE IA
                Surface(
                    color = MaterialTheme.colorScheme.surface,
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.4f)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(18.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Psychology,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Diagnóstico Vocacional Inteligente",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Responda abaixo para que nosso algoritmo recomende a rota profissional sob medida para você.",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        // Pergunta 1
                        Text(
                            text = "1. O que você mais tem vontade de aprender?",
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(6.dp))

                        val quizOptions = listOf(
                            "Criar sites e páginas visuais (Web/Front-end)",
                            "Criar servidores e bancos de dados (Back-end)",
                            "Construir aplicativos para celular (Android Mobile)",
                            "Analisar números, planilhas e gráficos (Dados & BI)",
                            "Desenhar interfaces e pesquisar usuários (UI/UX)",
                            "Proteger redes contra ataques (Cibersegurança)",
                            "Manutenção de computadores e redes (Suporte TI)"
                        )

                        quizOptions.forEach { opt ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(8.dp))
                                    .clickable { viewModel.onQuizInterestSelected(opt) }
                                    .padding(vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = uiState.quizInterest == opt,
                                    onClick = { viewModel.onQuizInterestSelected(opt) }
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = opt,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Button(
                            onClick = { viewModel.processAiQuiz() },
                            enabled = uiState.quizInterest.isNotBlank() && !uiState.isAnalyzingWithAi,
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            if (uiState.isAnalyzingWithAi) {
                                CircularProgressIndicator(
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("Processando Perfil com IA...")
                            } else {
                                Icon(imageVector = Icons.Default.AutoAwesome, contentDescription = null)
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("Descobrir Minha Trilha Ideal", fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }
            } else {
                // ABA DE ESCOLHA DIRETA NO CATÁLOGO
                Text(
                    text = "Escolha sua área de interesse inicial:",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onBackground
                )

                // Exibição da Justificativa da IA (se veio do Quiz)
                uiState.aiRecommendationJustification?.let { just ->
                    Spacer(modifier = Modifier.height(8.dp))
                    Surface(
                        color = MaterialTheme.colorScheme.primaryContainer,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.AutoAwesome,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Recomendação da IA: $just",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onPrimaryContainer,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                availableAreas.forEach { option ->
                    AreaOptionCard(
                        title = option.title,
                        categoryBadge = option.categoryBadge,
                        description = option.description,
                        icon = option.icon,
                        isSelected = uiState.selectedArea == option.title,
                        onClick = {
                            focusManager.clearFocus()
                            viewModel.onAreaSelected(option.title)
                        }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }

            // 6. Mensagem de Erro
            AnimatedVisibility(visible = uiState.errorMessage != null) {
                uiState.errorMessage?.let { errorMsg ->
                    Spacer(modifier = Modifier.height(12.dp))
                    Surface(
                        color = MaterialTheme.colorScheme.errorContainer,
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = errorMsg,
                            color = MaterialTheme.colorScheme.onErrorContainer,
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(12.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
private fun AreaOptionCard(
    title: String,
    categoryBadge: String,
    description: String,
    icon: ImageVector,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val borderColor by animateColorAsState(
        targetValue = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outlineVariant,
        label = "BorderColor"
    )
    val containerColor by animateColorAsState(
        targetValue = if (isSelected) MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.35f) else MaterialTheme.colorScheme.surface,
        label = "ContainerColor"
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(width = if (isSelected) 2.dp else 1.dp, color = borderColor),
        colors = CardDefaults.cardColors(containerColor = containerColor),
        elevation = CardDefaults.cardElevation(defaultElevation = if (isSelected) 2.dp else 0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.Top
        ) {
            Surface(
                color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.size(42.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(22.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Surface(
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.7f),
                    shape = RoundedCornerShape(6.dp),
                    modifier = Modifier.padding(bottom = 3.dp)
                ) {
                    Text(
                        text = categoryBadge,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                        fontWeight = FontWeight.Medium
                    )
                }

                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    lineHeight = 17.sp
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                imageVector = if (isSelected) Icons.Default.CheckCircle else Icons.Default.RadioButtonUnchecked,
                contentDescription = if (isSelected) "Selecionado" else "Não selecionado",
                tint = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outlineVariant,
                modifier = Modifier.size(22.dp)
            )
        }
    }
}
